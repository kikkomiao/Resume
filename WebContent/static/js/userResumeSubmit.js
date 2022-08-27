	function abcde() {//提交之前先校验数据
	var username=document.getElementById('username').value;//用户名
	var sex=getradio('sex');
	//alert("1");
	//alert(sex);
	var nation=document.getElementById('nation').value;//民族
	//alert(nation);
	var nativeplace=document.getElementById('nativeplace').value;//籍贯
	//alert(nativeplace);
	var birthday=document.getElementById('datepicker').value;
	//alert(birthday);
	var education=document.getElementById('education').value;//学历
	//alert(education);
	var major=document.getElementById('major').value;//专业
	//alert(major);
	var english=document.getElementById('english').value;//英语等级
	//alert(english);
	var politic=document.getElementById('politic').value;//政治面貌
	//alert(politic);
	var graduation=document.getElementById('graduation').value;//毕业院校
	//alert(graduation);
	var phone=document.getElementById('phone').value;//联系电话
	//alert(phone);
	var email=document.getElementById('email').value;//邮箱
	//alert(email);
	var worktarget=document.getElementById('worktarget').value;//求职意向
	//alert(worktarget);
	var interest=new Array();            //兴趣爱好
	interest=beginGet();
	var experience=document.getElementById('experience').value;//实习经历
	//alert(experience);
	var resumemessage=username+"\n"+sex+"\n"+nation+"\n"+nativeplace+"\n"+birthday+"\n"+education+"\n"+major+"\n"+english+"\n"+politic+"\n"+graduation+"\n";
	resumemessage+=phone+"\n"+email+"\n"+worktarget+"\n"+interest+"\n"+experience;
	//alert(resumemessage);//弹出所有数据
	if(username==""||sex==" "||education==""||phone==""||email==""){
		alert("姓名 性别 学历 联系电话 邮箱是必填项");
		return false;
	}else{
		return true;
	}
	}
	//获取单选按钮选中的值
	function getradio(name){
		var radio=document.getElementsByName(name);
		for(var i=0;i<radio.length;i++){
			if(radio[i].checked==true){
				value=radio[i].value;
				break;
			}
		}
		return value;
	}
 	//声明函数
    function beginGet() {//获取复选框的值
        //首先我们要得到多选框中有一些什么样的值
        var date = document.getElementsByName("interest");
        //然后我们去得到这个多选框的长度
        var thisLength = date.length;
        //使用字符串数组，用于存放选择好了的数据
        var str = new Array(6);
        for(var i = 0;i < thisLength;i++) {
            if (date[i].checked == true) {
                str[i] = date[i].value;//这个是获取多选框中的值
            }
        }
        //循环遍历，在控制台输出我们所选择的值
        for(var j in str){
            console.log(str[j]);
        }
        return str;
    }
function abc(){//测试表格中所有数据
	var username=document.getElementById('username').value;//用户名
	var sex=getradio('sex');
	//alert("1");
	//alert(sex);
	var nation=document.getElementById('nation').value;//民族
	//alert(nation);
	var nativeplace=document.getElementById('nativeplace').value;//籍贯
	//alert(nativeplace);
	var birthday=document.getElementById('datepicker').value;
	//alert(birthday);
	var education=document.getElementById('education').value;//学历
	//alert(education);
	var major=document.getElementById('major').value;//专业
	//alert(major);
	var english=document.getElementById('english').value;//英语等级
	//alert(english);
	var politic=document.getElementById('politic').value;//政治面貌
	//alert(politic);
	var graduation=document.getElementById('graduation').value;//毕业院校
	//alert(graduation);
	var phone=document.getElementById('phone').value;//联系电话
	//alert(phone);
	var email=document.getElementById('email').value;//邮箱
	//alert(email);
	var worktarget=document.getElementById('worktarget').value;//求职意向
	//alert(worktarget);
	var interest=new Array();            //兴趣爱好
	interest=beginGet();
	var experience=document.getElementById('experience').value;//实习经历
	//alert(experience);
	var resumemessage=username+"\n"+sex+"\n"+nation+"\n"+nativeplace+"\n"+birthday+"\n"+education+"\n"+major+"\n"+english+"\n"+politic+"\n"+graduation+"\n";
	resumemessage+=phone+"\n"+email+"\n"+worktarget+"\n"+interest+"\n"+experience;
	alert(resumemessage);//弹出所有数据
}