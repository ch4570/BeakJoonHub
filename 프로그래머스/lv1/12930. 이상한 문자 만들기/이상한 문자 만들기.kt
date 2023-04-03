class Solution {
    fun solution(s: String): String {
    val array = s.split(" ")
    var builder = StringBuilder()

    val answer = StringBuilder()

    for(i in array.indices) {
        val word = array[i]
        builder = StringBuilder(word)
        
        for(j in word.indices) {
            if (j % 2 == 0) {
                builder.setCharAt(j, builder[j].uppercaseChar())
            } else {
                builder.setCharAt(j, builder[j].lowercaseChar())
            }
        }

        if (i < array.size-1) {
            answer.append("$builder ")
        } else {
            answer.append("$builder")
        }
    }

    return answer.toString()
}
}