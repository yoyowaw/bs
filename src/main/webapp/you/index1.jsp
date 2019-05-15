<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>��¼</title>
	<link rel="stylesheet" href="./css/layui.css"> 
	<link rel="stylesheet" href="./css/index.css">
</head>

<body>
	<div class="login-wrap">
		<div class="login">
			<ul>
				<li>
					<input type="text" name="title" required lay-verify="required" placeholder="�û���" autocomplete="off" class="layui-input username" value='admin'>
				</li>	
				<li>
					<input type="password" name="title" required lay-verify="required" placeholder="����" autocomplete="off" class="layui-input userpasd" value='123'>
				</li>
				<li>
					<input type="text"name="title" required lay-verify="required" placeholder="��֤��" autocomplete="off" class="layui-input code" style='width: 70%'>
					<span class="checkcode">123123</span>
				</li>
				<li>
					<button class="layui-btn submit layui-btn-fluid">��¼</button>
				</li>
			</ul>
		</div>
	</div>
	<script src="./js/layui.js"></script> 
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script> 
	<script>
		$(function () {
			$('.login-wrap').height(window.innerHeight)
			console.log(window.innerHeight)

			$.ajax({
				url: 'http://localhost:4000/getcode',
				type: 'GET',
				success: function (num) {
					console.log(num)
					$('.checkcode').text(num)
					$('.code').val(num)
				}
			})

			$('.submit').click(function () {
				username = $('.username').val();
				userpasd = $('.userpasd').val();
				checkCode = $('.code').val() 
				if (!username) {
					alert('�û�������Ϊ��');
				} else if (!userpasd) {
					alert('���벻��Ϊ��');
				} else { 
					$.ajax({
						url: 'localhost:8080/user/login',
						type: "POST",
						data: {
							username,
							userpasd,
							checkCode,
						},
						dataType: "json",
						success: function (res) {
							if (res.userLoginDTO) { 
								window.localStorage.setItem('userInfo', JSON.stringify(res))
								alert('��¼�ɹ�')
								window.location.href = './home.html'
							}
						}, 
					})
				}

			})


		})

	</script>
</body>

</html>