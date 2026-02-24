// Main.kt
fun main() {
    val profiles = mutableListOf<UserProfile>()

    println("Welcome to the User Profile Generator!")
    print("How many profiles do you want to create? ")
    val numberOfProfiles = readLine()?.toIntOrNull() ?: 0

    for (i in 1..numberOfProfiles) {
        println("\n--- Profile #$i ---")
        print("Enter name: ")
        val name = readLine() ?: "Unknown"

        print("Enter age: ")
        val age = readLine()?.toIntOrNull() ?: 0

        print("Enter email: ")
        val email = readLine() ?: "N/A"

        // Add the new profile to the list
        profiles.add(UserProfile(name, age, email))
    }

    // Display all profiles
    println("\n===== User Profiles =====\n")
    for (profile in profiles) {
        displayProfile(profile)
    }
}

// Data class to hold user profile information
data class UserProfile(
    val name: String,
    val age: Int,
    val email: String
)

// Function to display a single profile
fun displayProfile(profile: UserProfile) {
    println("Name : ${profile.name}")
    println("Age  : ${profile.age}")
    println("Email: ${profile.email}")
    println("---------------------------\n")
}