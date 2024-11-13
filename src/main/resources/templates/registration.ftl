<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap"
            rel="stylesheet"
    />
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
        }

        .registration.form {
            background-color: #fff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .registration.form header {
            font-size: 24px;
            font-weight: 600;
            margin-bottom: 20px;
            text-align: center;
        }

        .registration.form input {
            display: block;
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
        }

        .registration.form .button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        .registration.form .button:hover {
            background-color: #0056b3;
        }
    </style>

    <script>
        function sendData() {
            const data = {
                username: document.querySelector('input[name="username"]').value,
                password: document.querySelector('input[name="password"]').value
            }

            fetch(
                '/registration', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                }
            )
                .then(response =>{
                        response.json();
                        if(response.ok) {
                            window.location.href='/login';
                        }
                    }
                )
                .then(res => console.log(res))
                .catch(error => console.log(error));
        }

    </script>

    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="registration form">
        <header >Registration form</header>
        <form onsubmit="sendData(); return false">
            <input type="text" name="username" placeholder="Login">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" class="button" value="Sign in">
        </form>
    </div>
</div>
</body>
</html>