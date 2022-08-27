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
  <title>查看简历</title>
  <link rel="stylesheet" href="<%=basePath%>static/css/ResumeView.css" type="text/css">
  <link rel="stylesheet" href="<%=basePath%>static/css/test1.css" type="text/css"/>
</head>
<body>

<button name="downLoad" id="downLoad" type="downLoad" href="javascript:void(0)" type="button" style="text-align: center; border-radius:50%;position: fixed;right: 5%;top: 80%;z-index: 4;
  width: 70px;height: 70px;box-shadow: 5px 5px 5px #888888;border: none;background-color:#467FE6;" v-if="orderObj != null">
  <i type="warning" class="el-icon-back" style="color:#fff;margin-top: 20%;font-size: 18px;"></i>
  <p style="font-size: 12px;font-weight:bolder;color:#fff;font-family: YOUYUAN;font-size: 14px;">下载简历</p>
</button>

<c:if test="${message <0 }">
  <script>
    alert("网络开小差了，请重新添加简历");
  </script>
</c:if>

<div class="hidden" style="visibility:hidden;">asfdddddddddddddddddddddddddddddddd</div>
<div id="resume">
  <form  method="post" enctype="multipart/form-data" accept-charset="UTF-8">
    <!-- 姓名 -->
    <!-- <h1 class="name" id="name"> -->


    <!-- </h1> -->
      <input disabled id="title" class="title" name="title" type="hidden"  value="${resume.title}" hidden="hidden"/>
    <div class="name">
      <input disabled id="name" class="name" name="name" type="text" placeholder="输入姓名" value="${resume.name}">
    </div>
    <!-- 意向 -->
    <div class="position">
      <div class="leftSymbol">
        <span class="s3">◆</span>
        <span class="s2">◆</span>
        <span class="s1">◆</span>
      </div>
      <div id="position" class="position">

        <input disabled class="position" name="target" type="text" placeholder="输入期望职位" value="${resume.target}">
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
            <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.2.1.min.js">
            </script>
          </div>
        </div>

        <div class="basinfo">
          <div class="info-item">
            <div class="title">
              基本资料
            </div><br />
            <ul>
              <li>年&emsp;&emsp;龄：
                <input disabled type="number" name="age" placeholder="输入年龄" value="${resume.age}">
              </li>

              <li>电&emsp;&emsp;话：
                <input disabled type="text" name="phone" placeholder="输入电话" value="${resume.phone}">
              </li>
              <li>邮&emsp;&emsp;箱：
                <input disabled type="text" name="email" placeholder="输入邮箱" value="${resume.email}">
              </li>
              <li>性&emsp;&emsp;别：
<%--                0：未填写，1：男，2：女--%>
                <c:if test="${resume.gender == 0}"></c:if>
                <c:if test="${resume.gender == 1}">
                  <text>男</text>
                </c:if>
                <c:if test="${resume.gender == 2}">
                  <text>女</text>
                </c:if>
              </li>

<%--              0：未填写，1：中共党员，2：预备党员，3：共青团员，4：群众--%>
              <li>政治面貌：
                <c:if test="${resume.politic == 0}"></c:if>
                <c:if test="${resume.politic == 1}">
                  <text>中共党员</text>
                </c:if>
                <c:if test="${resume.politic == 2}">
                  <text>预备党员</text>
                </c:if>
                <c:if test="${resume.politic == 3}">
                  <text>共青团员</text>
                </c:if>
                <c:if test="${resume.politic == 4}">
                  <text>群众</text>
                </c:if>
              </li>
            </ul>
          </div>

          <div class="info-item">
            <div class="title">
              教育经历
            </div><br />
            <ul>
              <li>学&emsp;&emsp;校：
                <input disabled type="text" name="school" placeholder="输入学校" value="${resume.school}">
              </li>

              <li>专&emsp;&emsp;业：
                <input disabled type="text" name="major" placeholder="输入专业" value="${resume.major}">
              </li>
              <li>毕业时间：
                <input disabled type="month" name="time" placeholder="输入毕业时间" value="${resume.time}">
              </li>
            </ul>
          </div>

            <c:if test="${skillflag == 1}">
                <div class="info-item">
                    <div class="title">
                        专业技能
                    </div>
                    <div><br/>
                        <textarea disabled name="skill" rows="8" cols="30">${resume.skill}</textarea>
                    </div>
                </div>
            </c:if>

            <c:if test="${awardflag == 1}">
                <div class="info-item">
                    <div class="title">
                        奖项荣誉
                    </div>
                    <br/>
                    <textarea disabled name="award" rows="8" cols="30">${resume.award}</textarea>
                </div>
            </c:if>

        </div>
      </div>

      <div class="right">
        <c:if test="${workflag == 1}">
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
                <c:forEach items="${work}" var="work_exp">
                    <li class="dot" id="dot1">
                                            <span>
                                                公&emsp;司：<input disabled name="company1" id="company1" type="text" placeholder="输入公司名称"
                                                                value="${work_exp.company}">
                                                时&emsp;间：<input disabled name="work_time1" id="worktime1" type="month"
                                                                value="${work_exp.worktime}">
                                            </span><br />
                      <p class="title1">经历描述:</p>
                      <textarea disabled name="work_exp1" id="textarea1" rows="5" cols="45">${work_exp.detail}</textarea><br /><br />
                    </li>
                </c:forEach>
              </ul>
            </div>
        </c:if>

        <c:if test="${itemflag == 1}">
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
              <c:forEach items="${item}" var="item_exp">
                  <li class="dot" id="dot1">
                                        <span>
                                            项&emsp;目：<input disabled name="item_name1" id="itemname1" type="text" placeholder="输入项目名称"
                                                            value="${item_exp.itemname}">
                                            时&emsp;间：<input disabled name="item_time1" id="itemtime1" type="month"
                                                            value="${item_exp.itemtime}">
                                        </span><br />
                    <p class="title1">经历描述:</p>
                    <textarea disabled name="item_exp1" id="textarea4" rows="5" cols="45">${item_exp.detail}</textarea><br /><br />
                  </li>
              </c:forEach>
            </ul>
          </div>
        </c:if>


        <c:if test="${assoflag == 1}">
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
                  <c:forEach items="${asso}" var="asso_exp">
                      <li class="dot" id="dot1">
                                              <span>
                                                  组&emsp;织：<input disabled name="asso_name1" id="assoname1" type="text" placeholder="输入组织名称"
                                                                  value="${asso_exp.assoname}">
                                                  时&emsp;间：<input disabled name="asso_time1" id="assotime1" type="month"
                                                                  value="${asso_exp.assotime}">
                                              </span><br />
                        <p class="title1">经历描述:</p>
                        <textarea disabled name="asso_exp1" id="textarea7" rows="5" cols="45">${asso_exp.detail}</textarea><br /><br />
                      </li>
                  </c:forEach>
                </ul>
              </div>
        </c:if>
      </div>
    </main>
  </form>
</div>
<div class="hidden" style="visibility:hidden;">asfdddddddddddddddddddddddddddddddd</div>

<script type="text/javascript">
  function makeExpandingArea(el) {
    var timer = null;
    //由于ie8有溢出堆栈问题，故调整了这里
    var setStyle = function(el, auto) {
      if (auto) el.style.height = 'auto';
      el.style.height = el.scrollHeight + 'px';
    }
    var delayedResize = function(el) {
      if (timer) {
        clearTimeout(timer);
        timer = null;
      }
      timer = setTimeout(function() {
        setStyle(el)
      }, 200);
    }
    if (el.addEventListener) {
      el.addEventListener('input', function() {
        setStyle(el, 1);
      }, false);
      setStyle(el)
    } else if (el.attachEvent) {
      el.attachEvent('onpropertychange', function() {
        setStyle(el)
      })
      setStyle(el)
    }
    if (window.VBArray && window.addEventListener) { //IE9
      el.attachEvent("onkeydown", function() {
        var key = window.event.keyCode;
        if (key == 8 || key == 46) delayedResize(el);

      });
      el.attachEvent("oncut", function() {
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


<%--下载简历为PDF--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
<script type="text/javascript">

  var downPdf = document.getElementById("downLoad");
  var title = document.getElementById("title").value;

  downPdf.onclick = function() {
    downPdf.parentNode.removeChild(downPdf);

    html2canvas(document.body, {
      onrendered:function(canvas) {

          //宽度
        var contentWidth = canvas.width;
        //高度
        var contentHeight = canvas.height;

        //一页pdf显示jsp页面生成的canvas高度;
        var pageHeight = contentWidth / 592.28 * 841.89;
        //未生成pdf的jsp页面高度
        var leftHeight = contentHeight;
        //pdf页面偏移
        var position = 0;
        //a4纸的尺寸[595.28,841.89]，jsp页面生成的canvas在pdf中图片的宽高
        var imgWidth = 595.28;
        var imgHeight = 592.28/contentWidth * contentHeight;

        var pageData = canvas.toDataURL('image/jpeg', 1.0);

        var pdf = new jsPDF('', 'pt', 'a4');

        //有两个高度需要区分，一个是jsp页面的实际高度，和生成pdf的页面高度(841.89)
        //当内容未超过pdf一页显示的范围，无需分页
        if (leftHeight < pageHeight) {
          pdf.addImage(pageData, 'JPEG', 0, 0, imgWidth, imgHeight );
        } else {
            //进行分页
          while(leftHeight > 0) {
            pdf.addImage(pageData, 'JPEG', 0, position, imgWidth, imgHeight)
            leftHeight -= pageHeight;
            //页面便宜,每显示一页，在竖直方向上则会-841.89
              //即第二页会显示【-841.89，-1682.78】范围内的内容，以此类推
            position -= 841.89;
            //避免添加空白页
            if(leftHeight > 0) {
              pdf.addPage();
            }
          }
        }

        <%--pdf.save(${resume.title}+'.pdf');--%>
        // pdf.save(name+'.pdf');

        //   保存为pdf，名字为简历的title
        pdf.save(title+'.pdf');
      }
    })
  }
</script>


</body>
</html>
