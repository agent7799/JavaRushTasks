package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
1. Заменим логическое И «&&» на умножение, а логическое ИЛИ «||» - на плюс
false && false  |   0 * 0   |   0
false && true   |   0 * 1   |   0
true  && false  |   1 * 0   |   0
true  && true   |   1 * 1   |   1

false || false  |   0 + 0   |   0
false || true   |   0 + 1   |   1
true  || false  |   1 + 0   |   1
true  || true   |   1 + 1   |   1

(abc!d) + (!ac) + (!bc) + (cd)

2. Раскроем скобки
abc!d   + !ac   + !bc   + cd

3. Вынесем «c» за скобки
c(ab!d  + !a    + !b    + d)

Здесь понадобятся базовые правила булевой алгебры
a + !a  = 1
a + ab  = a
a + !ab = a + b

4. Упростим «ab!d + !a»
c(b!d   + !a    + !b    + d)

5. Упростим «b!d + !b»
c(!d    + !a    + !b    + d)

6. Упростим «!d + d»
c(!a    + !b    + 1)

7. Теперь в скобках есть выражение «что-то + 1», что всегда дает «1» (вторая таблица)
c(1)

8. Теперь есть выражение «что-то * 1», что всегда дает «что-то» (первая таблица)
c
*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        //return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        return c;


    }

    public static void main(String[] args) {


    }
}
