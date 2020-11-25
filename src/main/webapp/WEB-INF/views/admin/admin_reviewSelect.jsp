<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>

<style type="text/css">



.admin-tbl h1 {
	font-size: 1.3em;
	font-weight: 700;
	margin-bottom: 10px;
	}
	
#ad-product-sel{
	margin-top: 50px;
	font-size: 0.9em;
	font-weight: 400;
}

#ad-product-sel p{
	margin-left: 10px;
}

#ad-product-sel_p1{
	color: #737373;
	margin-bottom: -8px;
}

#ad-product-sel_p2{
	font-size: 1.3em;
}

#ad-product-sel_p3{
	font-size: 1em;
}

#ad-product-sel_d1{
	width: 80%;
	border-top : 1px solid #d9d9d9;
	border-bottom : 1px solid #d9d9d9;
	padding: 10px 10px 150px 10px;
}

.ad-product-sel_btn{
	border: 2px solid #FDC033;
	color: #FDC033;
	font-size: 0.8em;
	font-weight: 500;
	float: right;
	margin: 10px 3px 0 0;
}



	
</style>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container" id="mbPage-container">
	<div class="row mem_title">
		<div class="col-12 col-md-3">
<c:import url="./adminPageRow.jsp"></c:import>
		</div>
		
	<div class="col-12 col-md-9 admin-tbl">
		<h1>Review</h1>
		<hr>
	<div id="ad-product-sel_all">	
		<div id="ad-product-sel">
			<p id="ad-product-sel_p1">${dto.productDTO.name} - ${dto.productDTO.color}</p>
			<hr width="40%">
			<p id="ad-product-sel_p3">작성자 : ${dto.id}</p>
			<div id="ad-product-sel_d1">
				${dto.contents}
			</div>
		</div>
		
		<a href="./admin_reviewList"><button class="btn btn-default ad-product-sel_btn" style="margin-right: 20%;">목록</button></a>
		<a onclick="window.open('../productQna/productQnaReplyInsert?review_num=${dto.review_num}','insert','width = 576, height = 373.2, top = 100, left = 200, location = no');">
		<button class="btn btn-default ad-product-sel_btn">답글</button></a>
		
	</div>
	</div>
		
	</div>
</div>


<script type="text/javascript">


</script>


</body>
</html>