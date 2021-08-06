# Задача 1. Тяжелые вычисления
## Описание
Представьте, что вам требуется провести очень сложные вычисления, которые займут крайне долгое время, если выполнять их на вашем компьютере. Допустим, что в некотором университете (МГУ, Оксфорд - кому что больше нравится) имеется суперкомпьютер, который мы можем использовать для наших вычислений. Тогда нам остается только передать данные для вычисления на суперкомпьютер (сервер) и дождаться ответа.

Задача заключается в том, чтобы сэмулировать подобную ситуацию, применив знания, полученные на лекции. В качестве вычисления можно взять задачу с вычислением N-го члена ряда Фибоначчи

## Работа программы
1. Старт сервера
1. Старт клиента. Пользователю предлагается ввести некоторое целое число
1. Считывание числа из консоли, передача его серверу
1. Сервер рассчитывает (рекурсивно или итеративно) N-ное число Фибоначчи и отправляет ответ обратно клиенту
1. Клиент должен отобразить рассчитанный сервером ответ

В комментариях укажите, почему именно был выбран именно этот способ взаимодействия (Blocking/NonBlocking)
