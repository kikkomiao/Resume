<%@ page import="Dao.WorkDao" %>
<%@ page import="Entity.Work" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Entity.Resume" %><%--
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
  <title>修改</title>
  <!--    <link rel="stylesheet" href="css/changeResume.css" type="text/css"/>-->
  <link rel="stylesheet" href="<%=basePath%>static/css/test1.css" type="text/css"/>
  <link rel="stylesheet" href="<%=basePath%>static/css/changeResume.css" type="text/css"/>

</head>
<body>

<%--<c:if test="${update == -1}">--%>
<%--  <script>--%>
<%--    alert("网络开小差了，请重新修改");--%>
<%--  </script>--%>
<%--</c:if>--%>

<div class="hidden" style="visibility:hidden;">asfdddddddddddddddddddddddddddddddd</div>
<div id="resume">
  <form action="<%=basePath%>update?method=updateResume&id=${resume.id}" onclick="test();" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
    <!-- 姓名 -->
    <!-- <h1 class="name" id="name"> -->

    <!-- </h1> -->
    <div class="name" id="name">
      <input class="name" name="name" type="text" placeholder="输入姓名" value="${resume.name}">
    </div>
    <!-- 意向 -->
    <div class="position">
      <div class="leftSymbol">
        <span class="s3">◆</span>
        <span class="s2">◆</span>
        <span class="s1">◆</span>
      </div>
      <div id="position" class="position">

        <input class="position" name="target" type="text" placeholder="输入期望职位" value="${resume.target}">
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
            <img id="headImg" name="pic" src="<%=basePath%>${resume.pic}" style="width: 100%;height:  100%;-webkit-border-radius: 8px;
                                                                -moz-border-radius: 8px;
                                                                border-radius: 50px;"/>
            <input type="file" accept="image/*" id="fileInput" name="pic" class="fileInput img-circle" value="<%=basePath%>${resume.pic}"/>
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
                <input type="text" name="age" placeholder="输入年龄" value="${resume.age}">
              </li>

              <li>电&emsp;&emsp;话：
                <input type="text" name="phone" placeholder="输入电话" value="${resume.phone}">
              </li>
              <li>邮&emsp;&emsp;箱：
                <input type="text" name="email" placeholder="输入邮箱" value="${resume.email}">
              </li>
              <li>性&emsp;&emsp;别：
                <select name="gender" id="gender">
                  <c:if test="${resume.gender == 1}">
                    <option id="0" value="0">尚未选择</option>
                    <option id="1" value="1" selected="selected">男</option>
                    <option id="2" value="2">女</option>
                  </c:if>
                  <c:if test="${resume.gender == 2}">
                    <option id="0" value="0">尚未选择</option>
                    <option id="1" value="1">男</option>
                    <option id="2" value="2" selected="selected">女</option>
                  </c:if>
                  <c:if test="${resume.gender == 0}">
                    <option id="0" value="0" selected="selected">尚未选择</option>
                    <option id="1" value="1">男</option>
                    <option id="2" value="2">女</option>
                  </c:if>
                </select>
              </li>
              <li>政治面貌：
                <select name="politic" id="politic">
                  <c:if test="${resume.politic==0}">
                    <option value="0" selected="selected">尚未选择</option>
                    <option value="1">中共党员</option>
                    <option value="2">预备党员</option>
                    <option value="3">共青团员</option>
                    <option value="4">群众</option>
                  </c:if>
                  <c:if test="${resume.politic==1}">
                    <option value="0">尚未选择</option>
                    <option value="1" selected="selected">中共党员</option>
                    <option value="2">预备党员</option>
                    <option value="3">共青团员</option>
                    <option value="4">群众</option>
                  </c:if>
                  <c:if test="${resume.politic==2}">
                    <option value="0">尚未选择</option>
                    <option value="1">中共党员</option>
                    <option value="2" selected="selected">预备党员</option>
                    <option value="3">共青团员</option>
                    <option value="4">群众</option>
                  </c:if>
                  <c:if test="${resume.politic==3}">
                    <option value="0">尚未选择</option>
                    <option value="1">中共党员</option>
                    <option value="2">预备党员</option>
                    <option value="3" selected="selected">共青团员</option>
                    <option value="4">群众</option>
                  </c:if>
                  <c:if test="${resume.politic==4}">
                    <option value="0">尚未选择</option>
                    <option value="1">中共党员</option>
                    <option value="2">预备党员</option>
                    <option value="3">共青团员</option>
                    <option value="4" selected="selected">群众</option>
                  </c:if>
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
                <input type="text" name="school" placeholder="输入学校" value="${resume.school}">
              </li>

              <li>专&emsp;&emsp;业：
                <input type="text" name="major" placeholder="输入专业" value="${resume.major}">
              </li>
              <li>毕业时间：
                <input type="text" name="time" placeholder="输入毕业时间" value="${resume.time}">
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
                                                                                            ·熟悉Jmeter等测试工具">${resume.skill}</textarea>
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
                                                                                            ·优秀毕业生">${resume.award}</textarea>
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
                                                        value="${work1.company}">
										时&emsp;间：<input name="work_time1" id="worktime1" type="text" placeholder="输入时间"
                                                        value="${work1.worktime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="work_exp1" id="textarea1" rows="1" cols="45"
                        placeholder="简短介绍公司与自己负责的项目，分罗列在什么项目中，通过某些动作或者技能达到可量化的结果">${work1.detail}</textarea><br/><br/>
            </li>
            <li class="dot" id="dot2">
									<span>
										公&emsp;司：<input name="company2" id="company2" type="text" placeholder="输入公司名称"
                                                        value="${work2.company}">
										时&emsp;间：<input name="work_time2" id="worktime2" type="text" placeholder="输入时间"
                                                        value="${work2.worktime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="work_exp2" id="textarea2" rows="1" cols="45"
                        placeholder="简短介绍公司与自己负责的项目，分罗列在什么项目中，通过某些动作或者技能达到可量化的结果">${work2.detail}</textarea><br/><br/>
            </li>
            <li class="dot" id="dot3">
									<span>
										公&emsp;司：<input name="company3" id="company3" type="text" placeholder="输入公司名称"
                                                        value="${work3.company}">
										时&emsp;间：<input name="work_time3" id="worktime3" type="text" placeholder="输入时间"
                                                        value="${work3.worktime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="work_exp3" id="textarea3" rows="1" cols="45"
                        placeholder="简短介绍公司与自己负责的项目，分罗列在什么项目中，通过某些动作或者技能达到可量化的结果">${work3.detail}</textarea><br/>
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
                                                        value="${item1.itemname}">
										时&emsp;间：<input name="item_time1" id="itemtime1" type="text" placeholder="输入时间"
                                                        value="${item1.itemtime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="item_exp1" id="textarea4" rows="1" cols="45"
                        placeholder="介绍在什么样的项目中自己负责的内容，列出通过什么动作或技能达到了怎样的效果，最好可量化">${item1.detail}</textarea><br/><br/>
            </li>
            <li class="dot" id="dot2">
									<span>
										项&emsp;目：<input name="item_name2" id="itemname2" type="text"
                                                        placeholder="输入项目名称"
                                                        value="${item2.itemname}">
										时&emsp;间：<input name="item_time2" id="itemtime2" type="text" placeholder="输入时间"
                                                        value="${item2.itemtime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="item_exp2" id="textarea5" rows="1" cols="45"
                        placeholder="介绍在什么样的项目中自己负责的内容，列出通过什么动作或技能达到了怎样的效果，最好可量化">${item2.detail}</textarea><br/><br/>
            </li>
            <li class="dot" id="dot3">
									<span>
										项&emsp;目：<input name="item_name3" id="itemname3" type="text"
                                                        placeholder="输入项目名称"
                                                        value="${item3.itemname}">
										时&emsp;间：<input name="item_time3" id="itemtime3" type="text" placeholder="输入时间"
                                                        value="${item3.itemtime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="item_exp3" id="textarea6" rows="1" cols="45"
                        placeholder="介绍在什么样的项目中自己负责的内容，列出通过什么动作或技能达到了怎样的效果，最好可量化">${item3.detail}</textarea><br/>
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
                                                        value="${asso1.assoname}">
										时&emsp;间：<input name="asso_time1" id="assotime1" type="text" placeholder="输入时间"
                                                        value="${asso1.assotime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="asso_exp1" id="textarea7" rows="1" cols="45"
                        placeholder="介绍在什么样的活动中自己负责的内容，列出通过该活动获得的成果">${asso1.detail}</textarea><br/><br/>
            </li>
            <li class="dot" id="dot2">
									<span>
										组&emsp;织：<input name="asso_name2" id="assoname2" type="text"
                                                        placeholder="输入组织名称"
                                                        value="${asso2.assoname}">
										时&emsp;间：<input name="asso_time2" id="assotime2" type="text" placeholder="输入时间"
                                                        value="${asso2.assotime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="asso_exp2" id="textarea8" rows="1" cols="45"
                        placeholder="介绍在什么样的活动中自己负责的内容，列出通过该活动获得的成果">${asso2.detail}</textarea><br/><br/>
            </li>
            <li class="dot" id="dot3">
									<span>
										组&emsp;织：<input name="asso_name3" id="assoname3" type="text"
                                                        placeholder="输入组织名称"
                                                        value="${asso3.assoname}">
										时&emsp;间：<input name="asso_time3" id="assotime3" type="text" placeholder="输入时间"
                                                        value="${asso3.assotime}">
									</span><br/>
              <p class="title1">经历描述:</p>
              <textarea name="asso_exp3" id="textarea9" rows="1" cols="45"
                        placeholder="介绍在什么样的活动中自己负责的内容，列出通过该活动获得的成果">${asso3.detail}</textarea><br/><br/>
            </li>
          </ul>
        </div>
      </div>
    </main>
    <button type="submit" href="javascript:void(0)" type="button" style="text-align: center; border-radius:50%;position: fixed;right: 5%;top: 80%;z-index: 4;
  width: 70px;height: 70px;box-shadow: 5px 5px 5px #888888;border: none;background-color:#467FE6;" v-if="orderObj != null">
      <i type="warning" class="el-icon-back" style="color:#fff;margin-top: 20%;font-size: 18px;"></i>
      <p style="font-size: 12px;font-weight:bolder;color:#fff;font-family: YOUYUAN;font-size: 14px;">修改简历</p>
    </button>
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

  var gender = document.getElementById('gender');
  $.each(gender.options, function (i, n) {
    if (n.value === ${resume.gender}) {
      n.selected = true;
    }
  });


  var politic = document.getElementById('politic');
  $.each(gender.options, function (i, n) {
    if (n.value === ${resume.politic}) {
      n.selected = true;
    }
  });
</script>
</body>
</html>
