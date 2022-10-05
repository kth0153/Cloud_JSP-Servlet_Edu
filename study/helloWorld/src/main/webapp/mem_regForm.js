var keyName = ["temail","tname","tpawd","thobby","taddr"];
var jsonList = [
]


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
        fn.action = "../helloWorld/SHW"; // 이동할 페이지
        fn.submit();
        
    });//e:$("form").on("submit")
    
    $("#pwd2").on("keypress",function(){ // 비밀번호 일치 확인
        passChk=false;
        if(fn.tpwd.value==fn.tpwd2.value) passChk=true;
        console.log(passChk);
    });//e:$("#pwd2").on("keypress")
    
	var $label;
    var labelText = ["운동", "독서", "낚시", "등산", "음악감상"];
	
    $("#btnReg").on("click", function() {
    	var email = fn.temail.value;
    	var name = fn.tname.value;
    	var pwd = fn.tpwd.value;
		// var hobby = $('input:checkbox[name="thobby"]:checked').val();
		
		 var select_obj = '';
  
        $('input[type="checkbox"]:checked').each(function (index) {
            if (index != 0) {
                select_obj += ', ';
            }
            // select_obj += $(this).val();
			$label=$("<label>");
			$label.text(labelText[index]);
			select_obj += $($label).val();
        });
  
        alert(select_obj);
		
		//for(var i=0;i<5;i++){
		
		//	$label=$("<label>");
		//	$label.text(labelText[i]);
			
		//}
		
    	$("#resultArea").append(email,name,pwd,select_obj,$label);
    	
    });
    

    
    
    
    
});//e:$().ready()