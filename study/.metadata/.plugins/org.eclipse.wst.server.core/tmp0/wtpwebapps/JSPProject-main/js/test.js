$().ready(function(){
//########################################################################
	//============ 파일을 선택할 경우 ====================
    $("#file").on("change", function() {
		console.log("파일선택");
    });//e:$("#file").on("change");
    //============ e:파일을 선택할 경우 ====================
    //============ 저장을 클릭 한경우 ====================
    $("#btnReg").on("click",function() {
		console.log("저장 클릭");
		
		fn.method = "post";
		fn.action = "CW";
		fn.submit();
		
	});//
	//============ e:저장을 클릭한 경우 ====================
	//============ 취소를 클릭한 경우 ====================
	$("#btnCan").on("click",function() {
		console.log("취소 클릭");
	});//
	//============ e:취소를 클릭한 경우 ====================
	
    
//########################################################################
});


	
/*	
	  //============ 파일을 선택할 경우 ====================
		if($("#filelist li:last-child").text() ==""){
			console.log("파일을 추가해 주세요");
		}else{
    	$("#file").on("change", function() {
		var formData = new FormData();
		//var inputFile = $('#file');
		const filesList = this.files;
		console.log(filesList);
		
		for(var i =0; i<filesList.length;i++){
			formData.append("file", filesList[i]);
			console.log(filesList[i]);
			$("#filelist li:last-child").append(filesList[i].name+"<br>"); // 파일 목록에 해당 파일명 추가
		}
			//$("#filelist li:last-child").append("파일이다");
	
			console.log("파일선택");			
		

	    });//e:$("#file").on("change");
		}
	    //============ e:파일을 선택할 경우 ====================
		
 		//============ 저장을 클릭 한경우 ====================
   		$("#btnReg").on("click",function() {
		var select = $("#tpart option:selected").text();
		var fname = $("#writer").val();
		var fsubject = $("#subject").val();
		var fcontent = $("#content").val();
		var fpassw = $("#password").val();
		// var filechk = $("#filelist li:last-child").text();
		
		if(select == "== 선택 =="){
			alert("머릿글을 선택해 주세요");
			return;
		}
		if(fname == ""){
			console.log("작성자 작성해 주세요");
			fname.focus();
			return;
		}
		if(fsubject == ""){
			console.log("제목을 작성해 주세요");
			//fsubject.focus();
			return;
		}
		if(fcontent == ""){
			console.log("내용을 작성해 주세요");
			//fcontent.focus();
			return;
		}
		if(fpassw == ""){
			console.log("비밀번호를 입력해 주세요");
			//fpassw.focus();
			return;
		}
		
		console.log("저장 클릭");
		
		/*$.ajax({
			url: "",
			data:{ // htlm value 값 (변수명 : 전달할 value 값)
	            fselect:select, 
	            fname:fname,
				fsubject: fsubject,
				fcontent: fcontent,
				fpassw : fpassw,
				formData
	        },
			processData : false,
            contentType: false,
			method:"GET",
			dataType: "text",
			success: function(data){
				
			},
			  error:function(request,status,error){
	           console.log("code:"+request.status);
	           console.log("message:"+request.responseText);
	           console.log("error:"+error);
			}
		});*/
		
	/*});//
	//============ e:저장을 클릭한 경우 ====================
	
	//============ 취소를 클릭한 경우 ====================
	$("#btnCan").on("click",function() {
		console.log("취소 클릭");
	});//
	//============ e:취소를 클릭한 경우 ====================
	*/
    
