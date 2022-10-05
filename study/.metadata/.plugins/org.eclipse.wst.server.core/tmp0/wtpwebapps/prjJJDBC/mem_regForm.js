
$().ready(function() { // jQery 시작
	
    var passChk = false;
    $("#btnReg").on("click",function(ev){
        if(fn.temail.value=="") {
            alert("비밀번호는 반드시 입력해야 합니다.");
            fn.temail.focus();
            return;
        }
        if(fn.tname.value=="") {
            alert("이름은 반드시 입력해야 합니다.");
            fn.tname.focus();
            return;
        }
        if(fn.tpwd.value=="") {
            alert("비밀번호는 반드시 입력해야 합니다.");
            fn.tpwd.focus();
            return;
        }
        if(fn.tpwd2.value=="") {
            alert("확인을 위한 비밀번호도 반드시 입력해야 합니다.");
            fn.tpwd2.focus();
            return;
        }
        if($("input:checked").length==0) {
            alert("취미는 하나 이상을 선택하셔야 합니다.");
            return;
        }
        if(fn.taddr.value=="") {
            alert("거주지를 선택해 주세요.");
            return;
        }
        
      	fn.method="get"; // 전송할 타입(get/post)
        fn.action = "/jdbcCtr/JDBCCtr"; // 이동할 페이지(회원가입)
        fn.submit();
       

    });//e:$("form").on("submit")

		var select_obj = '';
  
        $('input[type="checkbox"]:checked').each(function (index) {
		if (index != 0) {
                select_obj += ',';
            }
            select_obj += $(this).val();
        });

        //alert(select_obj);
	var jsonList;
    $.ajax({
	        url: "/prjJDBCList/JDBCList", // 해당 서블릿 주소
	        data:{ // htlm value 값 (변수명 : 전달할 value 값)
	            start : 0,
				len : 2,
				temail:fn.temail.value, 
	            tname:fn.tname.value,
				tpwd: fn.tpwd.value,
				thobby: select_obj,
				taddr : fn.taddr.value
	        },
	        method:"GET",
	        dataType: "text",/*json / text / html / xml / csv */

	        success : function(jsonData) { // 서블릿에서 넘어오는 값의 변수 값과 동일하게 선언해야함
				
	            jsonList=JSON.parse(jsonData);
				//console.log(jsonList);
				
				var keyName = ["fname","femail","fhobby","faddr","fdate"]; // JSON 키 값 가져 오기
				for(var i =0;i<jsonList.length;i++){
				var $tr = $("<tr></tr>");
					for(var j= 0;j<keyName.length;j++){
						var $td = $("<td></td>");
						$td.append(jsonList[i][keyName[j]]);
						$tr.append($td);
					}
					$("#resultArea tbody").append($tr);
				}
	        },
	        error:function(request,status,error){
	            console.log("code:"+request.status);
	            console.log("message:"+request.responseText);
	            console.log("error:"+error);
			}
		});
		
    $("#pwd2").on("keypress",function(){ // 비밀번호 일치 확인
        passChk=false;
        if(fn.tpwd.value==fn.tpwd2.value) passChk=true;
        console.log(passChk);
    });//e:$("#pwd2").on("keypress")
    
});//e:$().ready()