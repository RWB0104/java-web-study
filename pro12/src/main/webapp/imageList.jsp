<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">

	<title>이미지리스트창</title>

	<style>
		.lst_type {
			overflow: hidden;
			width: 80%;

			padding: 0px 10px 10px;
			margin: 0px auto;
		}

		.lst_type li {
			overflow: hidden;

			clear: both;
			margin: 10px 0px 0px;

			color: #2D2C2D;

			font-family: '돋움', Dotum;
			font-size: 12px;
			line-height: 100px;

			list-style: none;

			border-bottom: 2px solid lightgrey;
			position: relative;
		}

		.lst_type li img {
			display: inline;
			float: left;
			position: absolute;
		}

		.lst_type li a {
			color: #2D2C2D;

			text-decoration: none;
			margin-left: 340px;
		}

		.lst_type li a:hover {
			text-decoration: underline;
		}

		.lst_type li span {
			color: blue;

			margin-left: 30px;
			font-family: '돋움', Dotum;
			font-size: 14px;
		}
	</style>
</head>

<body>
	<ul class="lst_type">
		<li>
			<span style="margin-left: 50px">이미지</span>
			<span>이미지 이름</span>
			<span>선택하기</span>
		</li>

		<%
			for (int i = 0; i < 10; i++)
			{
		%>

		<li>
			<a href="#" style="margin-left: 50px">
				<img src="image/duke.png" width="90" height="90" alt="" />
			</a>
			<a href="#"><strong>이미지 이름: 듀크<%=i %></strong></a>
			<a href="#"><input name="chk<%=i %>" type="checkbox" /></a>
		</li>

		<%
			}
		%>
	</ul>
</body>

</html>