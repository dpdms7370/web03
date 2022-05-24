<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div>
		<h2글목록></h2>
		<form method="post" action="../GEtBoardSerchCtrl">
			<table class="table" id="serch_tb">
				<tr>
					<td>
						<select name="scd">
							<option vlaue="bobe">제목</option>
							<optin value="bsub">내용</optin>
						</select>
						<input type="text"/>
						<input type="submit"/>
						
					</td>			
			</table>
		</form>
		<table>
			<thead>
				<tr>
					<th class="t1">글번호</th>
					<th class="t2">글제목</th>
					<th class="t3">글쓴이</th>
					<th class="t4">작성일</th>
				</tr>	
			</thead>
			<tbody>
			<c:forEach item="${list } " var="bb" varStatus="status">

			<tr>
				<td>${status.count }</td>
				<td><a href="../GetBoardCtrl?num=${bb.bno }">${bb.bobe }</a></td>
				<td>${bb.bw }</td>
				<td>${bb.bdate }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4"><a href="addBoardForm.jsp">글 등록</a></td>
			</tr>	
		</tbody>
	</table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>