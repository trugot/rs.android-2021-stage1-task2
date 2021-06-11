package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val temp = a.toUpperCase()
        var c = ""
        for(letter in temp)
            if(letter in b)
                c += letter

        if (c == b)
            return "YES"
        return "NO"
    }
}