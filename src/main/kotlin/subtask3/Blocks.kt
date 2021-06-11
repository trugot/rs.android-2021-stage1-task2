package subtask3

import java.lang.NumberFormatException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    private fun sortLocalDataListAndGetString(array: List<Any?>): String {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val sortedArrayOfDates = array.sortedByDescending {
            LocalDate.parse(it.toString(), dateTimeFormatter)
        }
        val date = LocalDate.parse(sortedArrayOfDates[0].toString())
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return date.format(formatter)
    }


    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        val list = blockA.filter { it!!::class.simpleName == blockB.simpleName }

        var result: Any

        when (list[0]!!::class.simpleName) {
            "String" -> {
                result = ""
                for (item in list)
                    result += item
            }
            "Int" -> {
                result = 0
                for (item in list)
                    result += item.toString().toInt()
            }
            "LocalDate" -> {
                result = sortLocalDataListAndGetString(list)
            }
            else -> throw NumberFormatException("Something wrong")
        }
        return result
    }
}
