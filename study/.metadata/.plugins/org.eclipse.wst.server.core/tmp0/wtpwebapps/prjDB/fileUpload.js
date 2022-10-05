$().ready(function(){
	
	$("#uploadFile").on("change",function(ev){
		const filesList = this.files;
		
		// console.log(this.value);
		
		// $("#btnFile").click();
		
		fn.method = "post";
		fn.action = "fu";
		fn.submit();
		
		// alert("");
	}); // e:$(#btnFile)
	
});