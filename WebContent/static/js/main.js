// 定义函数
function show() {
	
	
	$("form[id='fromSave'] input:text").keydown(function(e){       
             var key = e.which; 
             if (key == 13) { 
             var inputs = $("form[id='fromSave']").find(":text"); // 获取表单中的所有输入框   
             var idx = inputs.index(this); // 获取当前焦点输入框所处的位置   
                // 获得id为info的input标签的内容
    			var a = document.getElementById('info').value;
    			// 显示，在id为result处动态显示（清除旧的显示新的）
    			document.getElementById('result').innerText = a;
			}
      });   

}
