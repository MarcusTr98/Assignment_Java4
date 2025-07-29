<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Quản lý bạn bè</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-body-secondary">

<div class="container mt-5">
	<div class="bg-white shadow rounded p-4">
		<h1 class="text-center display-6 fw-bold text-primary mb-4">Quản Lý Bạn Bè</h1>

		<form action="add" method="post">
			<div class="row g-3">
				<div class="col-md-6">
					<label class="form-label">Mã</label>
					<input class="form-control" name="ma">
					<small class="text-danger">${loiMa}</small>
				</div>
				<div class="col-md-6">
					<label class="form-label">Sở thích</label>
					<input class="form-control" name="soThich">
					<small class="text-danger">${loiSoThich}</small>
				</div>
				<div class="col-md-6">
					<label class="form-label">Tên</label>
					<input class="form-control" name="ten">
					<small class="text-danger">${loiTen}</small>
				</div>
				<div class="col-md-6">
					<label class="form-label d-block">Giới tính</label>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gioiTinh" id="nam" value="1" checked>
						<label class="form-check-label" for="nam">Nam</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gioiTinh" id="nu" value="0">
						<label class="form-check-label" for="nu">Nữ</label>
					</div>
				</div>
				<div class="col-12 text-center mt-3">
					<button onclick="return confirm('Bạn có chắc muốn thêm không?')" type="submit" class="btn btn-success btn-lg px-4">
						Add
					</button>
				</div>
			</div>
		</form>

		<hr class="my-5">

		<table class="table table-bordered table-hover align-middle">
			<thead class="table-primary text-center">
				<tr>
					<th>STT</th>
					<th>Mã Bạn</th>
					<th>Tên Bạn</th>
					<th>Sở thích</th>
					<th>Giới tính</th>
					<th>Hành Động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ban" items="${listBan}">
					<tr>
						<td class="text-center">${ban.id}</td>
						<td>${ban.maBan}</td>
						<td>${ban.tenBan}</td>
						<td>${ban.soThich}</td>
						<td>${ban.gioiTinh == 1 ? "Nam" : "Nữ"}</td>
						<td class="text-center">
							<a class="btn btn-danger btn-sm" href="remove?id=${ban.id}"
							   onclick="return confirm('Bạn có chắc muốn xóa không?')">Xóa</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
