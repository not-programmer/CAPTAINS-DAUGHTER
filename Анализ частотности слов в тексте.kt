import java.io.File
import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    print("Введите имя файла с текстом >> ")
    val name = sc.nextLine()
    val file = File("${name}.txt")
    val scFile = Scanner(file)
    val text = scFile.nextLine()
    println("Автор произведения - Александр Пушкин")
    println("Название произведения - Капитанская дочка")
    println("Текст произведения:")
    println(text)
    val wordlist = text.split(" ", ".", ",", "!", "?", "(", ")", ":", ";", "#", "№", "/", "|", "[", "]", "-", "–", "—", "_", "=", "+", "«", "»","<", ">", "{", "}", "^", "@", "'", "%", "&", "$")
    val map = hashMapOf<String, Int>()
    for (word in wordlist)
        if (word != "")
            if (word in map.keys) map[word] = map[word]!! + 1
            else map[word] = 1
    var mostOften = ""
    var countMostOften = 0
    var countOneTime = 0
    for ((oneWord,freq) in map) {
        if (freq > countMostOften ) {
            mostOften = oneWord
            countMostOften = freq
        }
        if (freq == 1) countOneTime ++
    }
    println("Количество слов в тексте: ${wordlist.size}")
    println("Самое часто встречающееся слово: $mostOften; встречается $countMostOften раз")
    println("Доля слов, которые встречаются только один раз (от общего числа слов): ${countOneTime/wordlist.size.toDouble()} (${(countOneTime/wordlist.size.toDouble())*100} %)")
}