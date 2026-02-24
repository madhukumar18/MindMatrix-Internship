// Data class to represent a student
data class Student(
    val name: String,
    val marks: List<Int>
)

// Function to calculate the average marks
fun calculateAverage(marks: List<Int>): Double {
    return if (marks.isNotEmpty()) {
        marks.sum().toDouble() / marks.size
    } else {
        0.0
    }
}

// Function to assign grade based on average marks
fun getGrade(average: Double): String {
    return when {
        average >= 90 -> "A+"
        average >= 80 -> "A"
        average >= 70 -> "B"
        average >= 60 -> "C"
        average >= 50 -> "D"
        else -> "F"
    }
}

// Function to determine performance level
fun getPerformanceLevel(average: Double): String {
    return when {
        average >= 80 -> "Excellent"
        average >= 70 -> "Good"
        average >= 60 -> "Average"
        average >= 50 -> "Below Average"
        else -> "Poor"
    }
}

// Function to find the highest and lowest marks
fun getHighestAndLowest(marks: List<Int>): Pair<Int, Int> {
    return Pair(marks.maxOrNull() ?: 0, marks.minOrNull() ?: 0)
}

// Function to generate a detailed student report
fun generateStudentReport(student: Student) {
    println("\n" + "=".repeat(60))
    println("STUDENT PERFORMANCE REPORT".padStart(35))
    println("=".repeat(60))

    println("Student Name: ${student.name}")
    println("Marks: ${student.marks.joinToString(", ")}")

    val average = calculateAverage(student.marks)
    val grade = getGrade(average)
    val performance = getPerformanceLevel(average)
    val (highest, lowest) = getHighestAndLowest(student.marks)

    println("\nPerformance Metrics:")
    println("  Average Marks: %.2f".format(average))
    println("  Grade: $grade")
    println("  Performance Level: $performance")
    println("  Highest Mark: $highest")
    println("  Lowest Mark: $lowest")

    // Determine if student passed
    val isPassed = average >= 50
    println("  Status: ${if (isPassed) "PASSED" else "FAILED"}")

    // Show feedback based on performance
    println("\nFeedback:")
    when {
        average >= 85 -> println("  Excellent work! Keep up the great performance.")
        average >= 70 -> println("  Good job! Continue your efforts to improve further.")
        average >= 60 -> println("  You can do better. Focus on your weak areas.")
        average >= 50 -> println("  You need to put in more effort to improve.")
        else -> println("  Please seek extra help and guidance to improve your grades.")
    }
    println("=".repeat(60))
}

fun main() {
    // Create a list of students with their marks
    val students = listOf(
        Student("Alice Johnson", listOf(95, 87, 92, 89, 94)),
        Student("Bob Smith", listOf(78, 82, 75, 80, 76)),
        Student("Charlie Brown", listOf(65, 68, 62, 70, 66)),
        Student("Diana Prince", listOf(45, 52, 48, 50, 46)),
        Student("Eva Wilson", listOf(88, 91, 85, 89, 92))
    )

    println("\n" + "*".repeat(60))
    println("STUDENT PERFORMANCE REPORT SYSTEM".padStart(35))
    println("*".repeat(60))

    // Loop through each student and generate their report
    for (student in students) {
        generateStudentReport(student)
    }

    // Summary Statistics
    println("\n" + "*".repeat(60))
    println("CLASS SUMMARY".padStart(30))
    println("*".repeat(60))

    var topStudent = students[0]
    var topAverage = calculateAverage(students[0].marks)

    // Loop to find the top student
    for (i in 1 until students.size) {
        val currentAverage = calculateAverage(students[i].marks)
        if (currentAverage > topAverage) {
            topAverage = currentAverage
            topStudent = students[i]
        }
    }

    println("Total Students: ${students.size}")
    println("Top Performer: ${topStudent.name} (Average: %.2f)".format(topAverage))

    println("\nClass Average by Performance Level:")

    val excellentCount = students.count { calculateAverage(it.marks) >= 80 }
    val goodCount = students.count {
        val avg = calculateAverage(it.marks)
        avg >= 70 && avg < 80
    }
    val averageCount = students.count {
        val avg = calculateAverage(it.marks)
        avg >= 60 && avg < 70
    }
    val belowAverageCount = students.count {
        val avg = calculateAverage(it.marks)
        avg >= 50 && avg < 60
    }
    val poorCount = students.count { calculateAverage(it.marks) < 50 }

    println("  Excellent: $excellentCount students")
    println("  Good: $goodCount students")
    println("  Average: $averageCount students")
    println("  Below Average: $belowAverageCount students")
    println("  Poor: $poorCount students")

    println("*".repeat(60))
}
