package subtask1

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val yearInt: Int = year.toIntOrNull() ?: throw NumberFormatException("Not A Number")
        val monthInt: Int = month.toIntOrNull() ?: throw NumberFormatException("Not A Number")
        val dayInt: Int = day.toIntOrNull() ?: throw NumberFormatException("Not A Number")
        val warStr = "Такого дня не существует"
        if(dayInt < 1 || dayInt > 31 || monthInt > 12 || monthInt < 1 || yearInt < 1)
            return warStr
        if(!checkLeapYear(year) && dayInt > 28)
            return warStr

        val monthText = when(monthInt){
            1 -> "января"
            2 -> "февраля"
            3 -> "марта"
            4 -> "апреля"
            5 -> "мая"
            6 -> "июня"
            7 -> "июля"
            8 -> "августа"
            9 -> "сентября"
            10 -> "октября"
            11 -> "ноября"
            else -> "декабря"
        }

        val y0: Int = yearInt - (14 - monthInt) / 12
        val x = y0 + y0 / 4 - y0 / 100 + y0 / 400
        val m0: Int = monthInt + 12 * ((14 - monthInt) / 12) - 2
        val dayOfWeekText =  when((dayInt + x + 31 * m0 / 12) % 7){
            1 -> "понедельник"
            2 -> "вторник"
            3 -> "среда"
            4 -> "четверг"
            5 -> "пятница"
            6 -> "суббота"
            else -> "воскресенье"
        }
        return "$day $monthText, $dayOfWeekText"
    }

    private fun checkLeapYear(year: String): Boolean{
        val yearInt: Int = year.toIntOrNull() ?: throw NumberFormatException("Not A Number")
        if(yearInt.rem(400) == 0)
            return true
        else if(yearInt.rem(4) == 0 && yearInt.rem( 100) != 0)
            return true
        return false

    }
}