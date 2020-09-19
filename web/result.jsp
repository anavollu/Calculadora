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

    #result-wrapper {
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

    .wrapper-item {
      margin-bottom: 20px;
      display: flex;
      flex-direction: column;
      font-size: 18px;
    }

    .text-center {
      text-align: center;
    }
  </style>
</head>
<body>
  <h1 class="text-center">Calculadora</h1>
  <div id="result-wrapper">
    <h2>Resultado</h2>
    <div class="wrapper-item">
      ${arg1} ${op} ${arg2} = ${result}
    </div>
    <div class="wrapper-item">
      Acesso nº ${accessNumber}
    </div>
  </div>
  </form>
</body>
</html>