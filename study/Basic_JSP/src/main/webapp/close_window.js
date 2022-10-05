$().ready(function(){
	  
		$("#btnClose").on("click",function(){
			if($("#chkBox").prop("checked")){   
				
		$.ajax({
	        url: "cookie_window.jsp", // 해당 서블릿 주소
	        method:"GET",
	        dataType: "text",/*json / text / html / xml / csv */

	        success : function(data) { // 서블릿에서 넘어오는 값의 변수 값과 동일하게 선언해야함
				if(data=='1'){
					alert("쿠키 저장 성공");
				}
				else{
	           		alert("쿠키 저장 실패");
				}
				
	        },
	        error:function(request,status,error){
	            console.log("code:"+request.status);
	            console.log("message:"+request.responseText);
	            console.log("error:"+error);
			}
	
	    	});//e:$("form").on("submit")
			$('#container').css("visibility","hidden");
			}
	  });
});