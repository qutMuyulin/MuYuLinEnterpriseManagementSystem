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

            <form role="form" enctype="multipart/form-data" action="<c:if test="${edit==true }">${path }/admin/inorder/update</c:if><c:if test="${edit==false }">${path }/admin/inorder/add</c:if><c:if test="${edit==null }">${path }/admin/inorder/save</c:if>" method="post">
              <input type="hidden" name="id" value="${record.id }">
              <div class="box-body">
                        <div class="form-group">
						  <label for="cangkuid">仓库</label>
                              <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="cangkuid">
                              <c:forEach items="${cangkus}" var="s">
                                  <option value="${s.id }" <c:if test="${s.id==record.cangkuid}"> selected </c:if>>
                                ${s.name }
                                  </option>
                              </c:forEach>
                              </select>
						</div>



                        <div class="form-group">
						  <label for="count">数量</label>
                                  <input type="number" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="count" value="${record.count}" id="count" placeholder="数量(只能为数字)">
						</div>

                  <div class="form-group">
                      <label for="count">金额</label>
                      <input type="number" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="total" value="${record.total}" id="total" placeholder="金额(只能为金额格式)">
                  </div>

                  <div class="form-group">
						  <label for="materidd">原料</label>
                            <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="materidd">
                                <c:forEach items="${maters}" var="s">
                                    <option value="${s.id }" <c:if test="${s.id==record.materidd}"> selected </c:if>>
                                            ${s.name }
                                    </option>
                                </c:forEach>
                            </select>						</div>


                        <div class="form-group">
						  <label for="customerid">客户</label>
                              <select class="form-control" <c:if test="${edit==false }">disabled</c:if> name="customerid">
                              <c:forEach items="${customers}" var="s">
                                  <option value="${s.id }" <c:if test="${s.id==record.customerid}"> selected </c:if>>
                                ${s.name }
                                  </option>
                              </c:forEach>
                              </select>
						</div>


                <div class="has-error">
                <span class="help-block">${msg }</span>
                </div>
              </div>

              <div class="box-footer">
  			<c:if test="${edit==false }"><a href="${path }/admin/inorder" class="btn btn-primary">返回</a></c:if>
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
$('#created').datepicker({
    language: 'zh-CN',
    autoclose: true
});

});
</script>
</html>
