<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/static.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="../common/menu.jsp"></jsp:include>
		 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">表单填写</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->

            <form role="form" enctype="multipart/form-data" action="<c:if test="${edit==true }">${path }/admin/staff/update</c:if><c:if test="${edit==false }">${path }/admin/staff/add</c:if><c:if test="${edit==null }">${path }/admin/staff/save</c:if>" method="post">
              <input type="hidden" name="id" value="${record.id }">
              <div class="box-body">
                        <div class="form-group">
                            <label for="name">名称</label>
                            <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="name" value="${record.name}" id="name" placeholder="名称">
                        </div>

                        <div class="form-group">
						  <label for="jobtypeid">工种</label>
                              <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="jobtypeid">
                              <c:forEach items="${jobtypes}" var="s">
                                  <option value="${s.id }" <c:if test="${s.id==record.jobtypeid}"> selected </c:if>>
                                ${s.name }
                                  </option>
                              </c:forEach>
                              </select>
						</div>


                        <div class="form-group">
						  <label for="orgid">部门</label>
                              <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="orgid">
                              <c:forEach items="${orgs}" var="s">
                                  <option value="${s.id }" <c:if test="${s.id==record.orgid}"> selected </c:if>>
                                ${s.name }
                                  </option>
                              </c:forEach>
                              </select>
						</div>


                        <div class="form-group">
						  <label for="sex">性别</label>
                              <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="sex" value="${record.sex}" id="sex" placeholder="性别">

						</div>

                        <div class="form-group">
						  <label for="basemoney">基本工资</label>
                              <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="basemoney" value="${record.basemoney}" id="basemoney" placeholder="基本工资">

						</div>

                        <div class="form-group">
						  <label for="desc">简介</label>
                              <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="desc" value="${record.desc}" id="desc" placeholder="简介">

						</div>

                        <div class="form-group">
						  <label for="intime">入职时间</label>
                              <input type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="intime" value="${record.intime}" id="intime" placeholder="入职时间">

						</div>

                        <div class="form-group">
						  <label for="picurl">头像</label>
                          <input type="file" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="file">
						</div>

                <div class="has-error">
                <span class="help-block">${msg }</span>
                </div>
              </div>

              <div class="box-footer">
  			<c:if test="${edit==false }"><a href="${path }/admin/staff" class="btn btn-primary">返回</a></c:if>
                 <c:if test="${edit==true || edit==null}"><button type="submit" class="btn btn-primary">保存</button></c:if>
                </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>

</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
$(function () {
//Date picker
$('#intime').datepicker({
    language: 'zh-CN',
    autoclose: true,
    format:'yyyy/mm/dd'

});

});
</script>
</html>
