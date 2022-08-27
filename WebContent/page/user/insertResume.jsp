<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/1/3
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();

    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":"
            + request.getServerPort()
            + path
            + "/";

    //pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>简历模板</title>
    <link rel="stylesheet" href="../../static/css/insertResume.css" type="text/css"/>
    <link rel="stylesheet" href="../../static/css/test1.css" type="text/css"/>
</head>

<body>

<c:if test="${message <0 }">
    <script>
        alert("网络开小差了，请重新添加简历");
    </script>
</c:if>

<div class="hidden" style="visibility:hidden;">asfdddddddddddddddddddddddddddddddd</div>
<div id="resume">
    <form id="form" action="<%=basePath%>insert?" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
        <!-- 姓名 -->
        <!-- <h1 class="name" id="name"> -->

        <!-- </h1> -->
        <div class="name" id="name">
            <input class="name" name="name" type="text" placeholder="输入姓名" value="">
        </div>
        <!-- 意向 -->
        <div class="position">
            <div class="leftSymbol">
                <span class="s3">◆</span>
                <span class="s2">◆</span>
                <span class="s1">◆</span>
            </div>
            <div id="position" class="position">

                <input class="position" name="target" type="text" placeholder="输入期望职位" value="">
            </div>
            <div class="rightSymbol">
                <span class="s1">◆</span>
                <span class="s2">◆</span>
                <span class="s3">◆</span>
            </div>
        </div>
        <!-- 分割线 -->
        <div class="splitLine">
            <p></p>
            <p></p>
        </div>
        <!-- 主体 -->
        <main>
            <div class="left">
                <!-- 照片 -->
                <div class="place">
                </div>
                <div style="overflow: hidden;" id="avatar">
                    <div class="avatar">
                        <img id="headImg" name="pic" src="<%=basePath%>static/img/newpic1.jpg"/>
                        <input type="file" accept="image/*" id="fileInput" name="pic" class="fileInput img-circle"/>
                        <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.2.1.min.js">
                        </script>
                        <script type="text/javascript">
                            //建立一個可存取到該file的url
                            function getObjectURL(file) {
                                // var img = document.getElementById("headImg");
                                var url = null;
                                if (window.createObjectURL != undefined) { // basic
                                    try {
                                        img.srcObject = file;
                                        url = file.srcObject;
                                    } catch (error) {
                                        url = window.createObjectURL(file);
                                    }
                                } else if (window.URL != undefined) { // mozilla(firefox)
                                    try {
                                        img.srcObject = file;
                                        url = file.srcObject;
                                    } catch (error) {
                                        url = window.URL.createObjectURL(file)
                                    }
                                } else if (window.webkitURL != undefined) { // webkit or chrome
                                    try {
                                        img.srcObject = file;
                                        url = file.srcObject;
                                    } catch (error) {
                                        url = window.webkitURL.createObjectURL(file);
                                    }
                                }
                                return url;
                            }

                            //用户的头像立即查看
                            (function ($) {
                                "use strict";
                                $("#fileInput").change(function () {
                                    var objUrl = null;
                                    objUrl = getObjectURL(this.files[0]);
                                    // var objUrl = "b.jpg";
                                    if (objUrl) {
                                        // alert(objUrl);
                                        $("#headImg").attr("src", objUrl); //?
                                    } else {
                                        alert("null");
                                    }
                                });
                            })(jQuery);
                        </script>
                    </div>
                </div>

                <div class="basinfo">
                    <div class="info-item">
                        <div class="title">
                            基本资料
                        </div>
                        <br/>
                        <ul>
                            <li>年&emsp;&emsp;龄：
                                <input type="number" name="age" placeholder="输入年龄" value="">
                            </li>

                            <li>电&emsp;&emsp;话：
                                <input type="text" name="phone" placeholder="输入电话" value="">
                            </li>
                            <li>邮&emsp;&emsp;箱：
                                <input type="text" name="email" placeholder="输入邮箱" value="">
                            </li>
                            <li>性&emsp;&emsp;别：
                                <select name="gender">
                                    <option value="0">尚未选择</option>
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </li>
                            <li>政治面貌：
                                <select name="politic">
                                    <option value="0">尚未选择</option>
                                    <option value="1">中共党员</option>
                                    <option value="2">预备党员</option>
                                    <option value="3">共青团员</option>
                                    <option value="4">群众</option>
                                </select>
                            </li>
                        </ul>
                    </div>

                    <div class="info-item">
                        <div class="title">
                            教育经历
                        </div>
                        <br/>
                        <ul>
                            <li>学&emsp;&emsp;校：
                                <input type="text" name="school" placeholder="输入学校" value="">
                            </li>

                            <li>专&emsp;&emsp;业：
                                <input type="text" name="major" placeholder="输入专业" value="">
                            </li>
                            <li>毕业时间：
                                <input type="month" name="time" placeholder="输入毕业时间" value="">
                            </li>
                        </ul>
                    </div>

                    <div class="info-item">
                        <div class="title">
                            专业技能
                        </div>
                        <div><br/>
                            <textarea name="skill" rows="8" cols="30" placeholder="输入专业技能，格式如下：
                                                                                            ·熟悉mysql数据库
                                                                                            ·熟悉SpirngBoot
                                                                                            ·熟悉Jmeter等测试工具"></textarea>
                        </div>
                    </div>

                    <div class="info-item">
                        <div class="title">
                            奖项荣誉
                        </div>
                        <br/>
                        <textarea name="award" rows="8" cols="30" placeholder="输入奖项荣誉，格式如下：
                                                                                            ·国家励志奖学金
                                                                                            ·蓝桥杯java开发
                                                                                            ·优秀毕业生"></textarea>
                    </div>

                </div>
            </div>

            <div class="right">
                <div class="exp-info">
                    <!-- 							<div class="title" >
                        工作经历
                    </div> -->
                    <div class="baseStyle clearfix jm0203_j1" id="resume_body">
                        <div class="workDiv baseItem positonDiv resume_item resume_add_area resume_sort resume_notice"
                             notice-key="work" id="resume_work" for-key="work">
                            <dl>
                                <dt><a class="resume_icon_diy icon wbdfont" for-id="work"
                                       style="font-size:none"></a>
                                    <span>
												<div class="resume_lang_work">工作经历</div>
												<div class="Border resume_line" for-id="work"
                                                     style="width:668px;border-top-style:solid;border-top-width:2px;">
												</div>
											</span>
                                </dt>
                            </dl>
                        </div>
                    </div>
                    <ul>
                        <li class="dot" id="dot1">
									<span>
										公&emsp;司：<input name="company1" id="company1" type="text" placeholder="输入公司名称"
                                                        value="">
										时&emsp;间：<input name="work_time1" id="worktime1" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="work_exp1" id="textarea1" rows="1" cols="45"
                                      placeholder="简短介绍公司与自己负责的项目，分罗列在什么项目中，通过某些动作或者技能达到可量化的结果"></textarea><br/><br/>
                        </li>
                        <li class="dot" id="dot2">
									<span>
										公&emsp;司：<input name="company2" id="company2" type="text" placeholder="输入公司名称"
                                                        value="">
										时&emsp;间：<input name="work_time2" id="worktime2" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="work_exp2" id="textarea2" rows="1" cols="45"
                                      placeholder="简短介绍公司与自己负责的项目，分罗列在什么项目中，通过某些动作或者技能达到可量化的结果"></textarea><br/><br/>
                        </li>
                        <li class="dot" id="dot3">
									<span>
										公&emsp;司：<input name="company3" id="company3" type="text" placeholder="输入公司名称"
                                                        value="">
										时&emsp;间：<input name="work_time3" id="worktime3" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="work_exp3" id="textarea3" rows="1" cols="45"
                                      placeholder="简短介绍公司与自己负责的项目，分罗列在什么项目中，通过某些动作或者技能达到可量化的结果"></textarea><br/>
                        </li>
                    </ul>
                </div>


                <div class="exp-info">
                    <!-- 							<div class="title">
                        项目经历
                    </div> -->
                    <div class="baseStyle clearfix jm0203_j1" id="resume_body">
                        <div class="eduDiv baseItem positonDiv resume_item resume_add_area resume_sort resume_notice"
                             notice-key="edu" id="resume_edu" for-key="edu">
                            <dl>
                                <dt><a class="resume_icon_diy icon wbdfont" for-id="edu"
                                       style="font-size:none"></a>
                                    <span>
												<div class="resume_lang_edu">项目经历</div>
												<div class="Border resume_line" for-id="edu"
                                                     style="width:668px;border-top-style:solid;border-top-width:2px;">
												</div>
											</span>
                                </dt>
                            </dl>
                        </div>
                    </div>
                    <ul>
                        <li class="dot" id="dot1">
									<span>
										项&emsp;目：<input name="item_name1" id="itemname1" type="text"
                                                        placeholder="输入项目名称"
                                                        value="">
										时&emsp;间：<input name="item_time1" id="itemtime1" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="item_exp1" id="textarea4" rows="1" cols="45"
                                      placeholder="介绍在什么样的项目中自己负责的内容，列出通过什么动作或技能达到了怎样的效果，最好可量化"></textarea><br/><br/>
                        </li>
                        <li class="dot" id="dot2">
									<span>
										项&emsp;目：<input name="item_name2" id="itemname2" type="text"
                                                        placeholder="输入项目名称"
                                                        value="">
										时&emsp;间：<input name="item_time2" id="itemtime2" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="item_exp2" id="textarea5" rows="1" cols="45"
                                      placeholder="介绍在什么样的项目中自己负责的内容，列出通过什么动作或技能达到了怎样的效果，最好可量化"></textarea><br/><br/>
                        </li>
                        <li class="dot" id="dot3">
									<span>
										项&emsp;目：<input name="item_name3" id="itemname3" type="text"
                                                        placeholder="输入项目名称"
                                                        value="">
										时&emsp;间：<input name="item_time3" id="itemtime3" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="item_exp3" id="textarea6" rows="1" cols="45"
                                      placeholder="介绍在什么样的项目中自己负责的内容，列出通过什么动作或技能达到了怎样的效果，最好可量化"></textarea><br/>
                        </li>
                    </ul>
                </div>

                <div class="exp-info">
                    <!-- 							<div class="title">
                        社团经历
                    </div> -->
                    <div class="baseStyle clearfix jm0203_j1" id="resume_body">
                        <div class="outexperDiv baseItem positonDiv resume_item resume_add_area resume_sort resume_notice"
                             notice-key="project" id="resume_project" for-key="project">
                            <dl>
                                <dt><a class="resume_icon_diy icon wbdfont" for-id="project"
                                       style="font-size:none"></a>
                                    <span>
												<div class="resume_lang_project">社团经历</div>
												<div class="Border resume_line" for-id="project"
                                                     style="width:668px;border-top-style:solid;border-top-width:2px;">
												</div>
											</span>
                                </dt>
                            </dl>
                        </div>
                    </div>
                    <ul>
                        <li class="dot" id="dot1">
									<span>
										组&emsp;织：<input name="asso_name1" id="assoname1" type="text"
                                                        placeholder="输入组织名称"
                                                        value="">
										时&emsp;间：<input name="asso_time1" id="assotime1" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="asso_exp1" id="textarea7" rows="1" cols="45"
                                      placeholder="介绍在什么样的活动中自己负责的内容，列出通过该活动获得的成果"></textarea><br/><br/>
                        </li>
                        <li class="dot" id="dot2">
									<span>
										组&emsp;织：<input name="asso_name2" id="assoname2" type="text"
                                                        placeholder="输入组织名称"
                                                        value="">
										时&emsp;间：<input name="asso_time2" id="assotime2" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="asso_exp2" id="textarea8" rows="1" cols="45"
                                      placeholder="介绍在什么样的活动中自己负责的内容，列出通过该活动获得的成果"></textarea><br/><br/>
                        </li>
                        <li class="dot" id="dot3">
									<span>
										组&emsp;织：<input name="asso_name3" id="assoname3" type="text"
                                                        placeholder="输入组织名称"
                                                        value="">
										时&emsp;间：<input name="asso_time3" id="assotime3" type="month"
                                                        value="">
									</span><br/>
                            <p class="title1">经历描述:</p>
                            <textarea name="asso_exp3" id="textarea9" rows="1" cols="45"
                                      placeholder="介绍在什么样的活动中自己负责的内容，列出通过该活动获得的成果"></textarea><br/><br/>
                        </li>
                    </ul>
                </div>
            </div>
        </main>
        <!--        <input type="submit" value="submit">-->
        <button name="submit" id="submit" type="submit" href="javascript:void(0)" type="button" style="text-align: center; border-radius:50%;position: fixed;right: 5%;top: 80%;z-index: 4;
  width: 70px;height: 70px;box-shadow: 5px 5px 5px #888888;border: none;background-color:#467FE6;" v-if="orderObj != null">
            <i type="warning" class="el-icon-back" style="color:#fff;margin-top: 20%;font-size: 18px;"></i>
            <p style="font-size: 12px;font-weight:bolder;color:#fff;font-family: YOUYUAN;font-size: 14px;">填报简历</p>
        </button>
        <input id="title" name="title" hidden="hidden">
        <script type="text/javascript">
            var btn = document.getElementById('submit');
            btn.onclick = function () {
                var temp = prompt("请输入简历名称","新建简历");
                // if(temp==null){
                //     alert("取消");
                // } else if(temp=="新建简历"){
                //     alert("空");
                // }else{
                //     alert(temp);
                // }
                if(temp==null){
                    document.getElementById("form").action="";
                }
                document.getElementById("title").value = temp;
            };
        </script>
    </form>
</div>
<div class="hidden" style="visibility:hidden;">asfdddddddddddddddddddddddddddddddd</div>

<script type="text/javascript">
    function makeExpandingArea(el) {
        var timer = null;
        //由于ie8有溢出堆栈问题，故调整了这里
        var setStyle = function (el, auto) {
            if (auto) el.style.height = 'auto';
            el.style.height = el.scrollHeight + 'px';
        }
        var delayedResize = function (el) {
            if (timer) {
                clearTimeout(timer);
                timer = null;
            }
            timer = setTimeout(function () {
                setStyle(el)
            }, 200);
        }
        if (el.addEventListener) {
            el.addEventListener('input', function () {
                setStyle(el, 1);
            }, false);
            setStyle(el)
        } else if (el.attachEvent) {
            el.attachEvent('onpropertychange', function () {
                setStyle(el)
            })
            setStyle(el)
        }
        if (window.VBArray && window.addEventListener) { //IE9
            el.attachEvent("onkeydown", function () {
                var key = window.event.keyCode;
                if (key == 8 || key == 46) delayedResize(el);

            });
            el.attachEvent("oncut", function () {
                delayedResize(el);
            }); //处理粘贴
        }
    }

    var textarea1 = document.getElementById('textarea1');
    var textarea2 = document.getElementById('textarea2');
    var textarea3 = document.getElementById('textarea3');
    var textarea4 = document.getElementById('textarea4');
    var textarea5 = document.getElementById('textarea5');
    var textarea6 = document.getElementById('textarea6');
    var textarea7 = document.getElementById('textarea7');
    var textarea8 = document.getElementById('textarea8');
    var textarea9 = document.getElementById('textarea9');
    makeExpandingArea(textarea1);
    makeExpandingArea(textarea2);
    makeExpandingArea(textarea3);
    makeExpandingArea(textarea4);
    makeExpandingArea(textarea5);
    makeExpandingArea(textarea6);
    makeExpandingArea(textarea7);
    makeExpandingArea(textarea8);
    makeExpandingArea(textarea9);
</script>
</body>
</html>
