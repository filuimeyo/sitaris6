
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<head>
    <title>Lab6 sitaris</title>
    <style>

        @import url('https://fonts.cdnfonts.com/css/bebas-neue');
        @import url('https://fonts.cdnfonts.com/css/trocchi-3');
        body {
            padding-top: 2rem;
        }

        .container {
            width: 60%;
            margin-top: 3rem;
            margin: auto;
            display: flex;
            justify-content: left;
            align-items: center;
            flex-wrap: wrap;
        }



        h1 {
            margin: auto;
            font-size: 2.5rem;
            letter-spacing: 0.6px;
            text-align: center;
            font-family: 'Bebas Neue', sans-serif;
            color: rgb(63, 105, 106);
        }

        .product {
            width: 180px;
            height: 130px;
            margin: 1rem;
            padding: 0.7rem;
            background: #dde3e9;
            position: relative;
            border-radius: 12px;
            overflow: hidden;
            border: none;
            transition: all 0.4s cubic-bezier(0.175, 0.885, 0, 1);
            box-shadow: 0px 13px 10px -7px rgba(0, 0, 0, 0.1);
        }

        .product:hover {
            box-shadow: 0px 30px 18px -8px rgba(0, 0, 0, 0.1);
            transform: scale(1.05, 1.05);
        }

        .product *{
            margin: 0;
        }

        .product h4{
            font-family: 'Bebas Neue', sans-serif;
        }

        .product h3{

            font-family: 'Trocchi', sans-serif;
            font-size: 0.95rem;
            margin: 0;
            margin-bottom: 0.3rem;
            -webkit-line-clamp: 2; /* Число отображаемых строк */
            display: -webkit-box; /* Включаем флексбоксы */
            -webkit-box-orient: vertical; /* Вертикальная ориентация */
            overflow: hidden;
        }

        .product .type{
            font-family: 'Bebas Neue', sans-serif;
        }

        .product .price{
            font-family: 'Bebas Neue', sans-serif;
            font-size: 1.2rem;
            font-weight: 700;
            color: cadetblue;
        }

        .product .price::after{
            content: " byn";
        }

        
    </style>
</head>
<html>
    <body>


    <h1>каталог товаров:</h1>

    <hr/>

    <div class="container">

        <c:forEach var="product" items="${products}">
            <div class="product">
                <h3><c:out value="${product.getName()}" /></h3>
                <h4><c:out value="${product.getBrand()}" /></h4>
                <p class="type"><c:out value="${product.getType()}" /></p>
                <p class="price"><c:out value="${product.getPrice()}" /></p>
            </div>
        </c:forEach>

    </div>

    <hr/>


    <div class="diagram">
        <canvas id="myChart"></canvas>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>

        const arr =${names}
        const prices = ${prices}



        const avg = Array(prices.length).fill(${avg})
        const ctx = document.getElementById('myChart');





        new Chart(ctx, {

            data: {
                labels: arr,
                datasets: [{
                    type: 'bar',
                    label: 'график цен',
                    data: prices,
                    borderWidth: 0.5,
                    backgroundColor: 'cadetblue',
                },{
                    type: 'line',
                    label: 'Avarage price',
                    data: avg
                    }
                ]
            },

            options: {

                scales: {
                    y: {
                        beginAtZero: true
                    }

                }
            }
        });
    </script>


    </body>
</html>
