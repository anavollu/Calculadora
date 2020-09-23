<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
            html {
                font-family: sans-serif;
            }

            #calcular-form {
                display: flex;
                flex-direction: column;
                max-width: 320px;
                margin: 0 auto;
                min-height: 200px;
                border: solid black 1px;
                border-radius: 4px;
                padding: 16px;
                margin-top: 48px;
                box-sizing: border-box;
            }

            #calcular-submit {
                color: white;
                background-color: black;
                border: 3px solid black;
                box-sizing: border-box;
            }

            #calcular-submit:hover {
                color: black;
                background-color: white;
            }

            .form-item,
            #operation-select,
            #calcular-submit,
            input {
                font-size: 18px;
            }

            .form-item {
                margin-bottom: 20px;
                display: flex;
                flex-direction: column;
            }

            .text-center {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1 class="text-center">Calculadora</h1>
        <form id="calcular-form" method="post">
            <div class="form-item">
                <label for="arg1">Valor1</label>
                <input type="number" required step="1" name="arg1"value="${arg1}">
            </div>
            <div class="form-item">
                <label for="arg2">Valor2</label>
                <input type="number" required step="1" name="arg2" value="${arg2}">
            </div>
            <div class="form-item">
                <label for="operation-select">Operação</label>
                <select name="operation-select" id="operation-select">
                    <option value="sum">Somar</option>
                    <option value="subtract">Subtrair</option>
                    <option value="multiply">Multiplicar</option>
                    <option value="divide">Dividir</option>
                </select>
            </div>
            <div class="form-item">
                <input id="calcular-submit" type="submit" value="Calcular"></input>
            </div>
        </form>
    </body>
</html>