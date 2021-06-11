package subtask3

import java.lang.NumberFormatException
import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        var result: Any

        when (blockB) {
            String::class -> {
                val list = blockA.filterIsInstance<String>()
                result = ""
                for (item in list)
                    result += item
            }
            Int::class -> {
                val list = blockA.filterIsInstance<Int>()
                result = 0
                for (item in list)
                    result += item.toString().toInt()
            }
            LocalDate::class -> {
                val date = blockA.filterIsInstance<LocalDate>().max() ?: throw DateTimeException("Wrong Date")
                val form = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                result = date.format(form)
            }
            else -> throw NumberFormatException("Something wrong")
        }
        return result
    }
}
