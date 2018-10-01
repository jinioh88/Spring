<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='bno' value="${boardVO.bno}"> <input
		type='hidden' name='page' value="${cri.page}"> <input
		type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${boardVO.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer" class="form-control" value="${boardVO.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-warning">Modify</button>
					<button type="submit" class="btn btn-danger">REMOVE</button>
					<button type="submit" class="btn btn-primary">GO LIST</button>
				</div>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

		<div class="row">
			<div class="col-md-12">
				<div class="box box-success">
					<div class="header">
						<h3 class="box">ADD NEW REPLY</h3>
					</div>
					<div class="box-body">
						<label for="newReplyWriter">Writer</label>
						<input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter">
						<label for="newReplyWriter">ReplyText</label>
						<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyWriter">
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
					</div>
				</div>
				<ul class="timeline">
					<!-- timeline time label -->
					<li class="time-label" id="repliesDiv">
		  <span class="bg-green">
		    Replies List <small id='replycntSmall'> [ ${boardVO.replycnt} ] </small>
		    </span>
					</li>
				</ul>

				<div class='text-center'>
					<ul id="pagination" class="pagination pagination-sm no-margin ">

					</ul>
				</div></div>
		</div>

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script>
    $(document).ready(function() {

        var formObj = $("form[role='form']");

        console.log(formObj);

        $(".btn-warning").on("click", function() {
            formObj.attr("action", "/sboard/modifyPage");
            formObj.attr("method", "get");
            formObj.submit();
        });

        $(".btn-danger").on("click", function() {
            formObj.attr("action", "/sboard/removePage");
            formObj.submit();
        });

        $(".btn-primary").on("click", function() {
            formObj.attr("method", "get");
            formObj.attr("action", "/sboard/list");
            formObj.submit();
        });

    });
</script>


<%@include file="../include/footer.jsp"%>
