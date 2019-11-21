import kotlin.Comparator

data class Person(
    val lastName: String,
    val firstName: String,
    var age: Int,
    var postIndex: Int,
    var phoneNumber: String
) {
    companion object : Comparator<Person> {
        override fun compare(p0: Person, p1: Person) = comparePersons(p0, p1)
    }
}

object PersonComparator : Comparator<Person> {
    override fun compare(p0: Person, p1: Person) = comparePersons(p0, p1)
}

fun comparePersons(p0: Person, p1: Person): Int {
    val lastNameCompareResult = p0.lastName.compareTo(p1.lastName)
    val firstNameCompareResult = p0.firstName.compareTo(p1.firstName)
    val ageCompareResult = p0.age.compareTo(p1.age)
    val postIndexCompareResult = p0.postIndex.compareTo(p1.postIndex)
    val phoneNumberCompareResult = p0.phoneNumber.compareTo(p1.phoneNumber)
    val personCompareResult = when {
        lastNameCompareResult != 0 -> lastNameCompareResult
        firstNameCompareResult != 0 -> firstNameCompareResult
        ageCompareResult != 0 -> ageCompareResult
        postIndexCompareResult != 0 -> postIndexCompareResult
        phoneNumberCompareResult != 0 -> phoneNumberCompareResult
        else -> 0
    }
    return when {
        personCompareResult == 0 -> 0
        personCompareResult > 0 -> 1
        else -> -1
    }
}

fun main() {
    val personIvan = Person("Ivanov", "Ivan", 22, 390000, "89000000000")
    val personAnotherIvan = Person("Ivanov", "Ivan", 22, 390000, "89000000000")
    val personOldIvan = Person("Ivanov", "Ivan", 92, 390000, "89000000000")
    val somePerson = Person("Smith", "John", 35, 390040, "89000000098")
    println("First variant:")
    println(PersonComparator.compare(personIvan, personAnotherIvan))
    println(PersonComparator.compare(personIvan, somePerson))
    println(PersonComparator.compare(personOldIvan, personAnotherIvan))
    println("Second variant:")
    println(Person.compare(personIvan, personAnotherIvan))
    println(PersonComparator.compare(personIvan, somePerson))
    println(PersonComparator.compare(personOldIvan, personAnotherIvan))
}