package com.example.roomie


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class inquiryQuestion : AppCompatActivity() {
    private lateinit var RadioGroupone: RadioGroup
    private lateinit var RadioGrouptwo: RadioGroup
    private lateinit var RadioGroupthree: RadioGroup
    private lateinit var RadioGroupfour: RadioGroup
    private lateinit var RadioGroupfive: RadioGroup
    private lateinit var RadioGroupsix: RadioGroup
    private lateinit var RadioGroupseven: RadioGroup
    private lateinit var RadioGroupieight: RadioGroup
    private lateinit var RadioGroupnine: RadioGroup
    private lateinit var RadioGroupten: RadioGroup
    private lateinit var submitButton: Button
    private lateinit var resultText: TextView

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inquiry_question)


        RadioGroupone = findViewById(R.id.answerRadioGroupOne)
        RadioGrouptwo = findViewById(R.id.answerRadioGroupTwo)
        RadioGroupthree = findViewById(R.id.answerRadioGroupThree)
        RadioGroupfour = findViewById(R.id.answerRadioGroupFour)
        RadioGroupfive = findViewById(R.id.answerRadioGroupFive)
        RadioGroupsix = findViewById(R.id.answerRadioGroupSix)
        RadioGroupseven = findViewById(R.id.answerRadioGroupSeven)
        RadioGroupieight = findViewById(R.id.answerRadioGroupEight)
        RadioGroupnine = findViewById(R.id.answerRadioGroupNine)
        RadioGroupten = findViewById(R.id.answerRadioGroupTen)


        submitButton = findViewById(R.id.submitButton)
        resultText = findViewById(R.id.resultText)

        submitButton.setOnClickListener {val user1Answers = getUserAnswers()
            // Assuming you have a way to get user2Answers (e.g., from another activity or input)
            val user2Answers = getUserAnswers() // Replace with actual user2 data
            val similarityPercentage = calculateSimilarityPercentage(user1Answers, user2Answers)
            resultText.text = "Similarity: $similarityPercentage%"
        }
    }

    private fun getUserAnswers(): UserAnswers {
        val livelihood = getSelectedAnswer(RadioGroupone)
        val partners = getSelectedAnswer(RadioGrouptwo)
        val ageGroup = getSelectedAnswer(RadioGroupthree)
        val cleanliness = getSelectedAnswer(RadioGroupfour)
        val foodPreference = getSelectedAnswer(RadioGroupfive)
        val drinkingHabits = getSelectedAnswer(RadioGroupsix)
        val stayDuration = getSelectedAnswer(RadioGroupseven)
        val budget = getSelectedAnswer(RadioGroupieight)
        val privacy = getSelectedAnswer(RadioGroupnine)
        val city = getSelectedAnswer(RadioGroupten)

        return UserAnswers(livelihood, partners, ageGroup, cleanliness, foodPreference,
            drinkingHabits, stayDuration, budget, privacy, city)
    }

    private fun getSelectedAnswer(radioGroup: RadioGroup): String {
        val selectedId = radioGroup.checkedRadioButtonId
        if (selectedId != 1) {
            val radioButton = findViewById<RadioButton>(selectedId)
            return radioButton.text.toString()
        }
        return "" // Or handle the case where no answer is selected
    }

    // Data class to store answers
    data class UserAnswers(
        val livelihood: String,
        val partners:String,
        val ageGroup: String,
        val cleanliness: String,
        val foodPreference: String,
        val drinkingHabits: String,
        val stayDuration: String,
        val budget: String,
        val privacy: String,
        val city: String
    )

    // Function to calculate the percentage of similar answers
    private fun calculateSimilarityPercentage(user1Answers: UserAnswers, user2Answers: UserAnswers): Int {
        var matchingAnswers = 0

        if (user1Answers.livelihood == user2Answers.livelihood) matchingAnswers++
        if (user1Answers.partners == user2Answers.partners) matchingAnswers++
        if (user1Answers.ageGroup == user2Answers.ageGroup) matchingAnswers++
        if (user1Answers.cleanliness == user2Answers.cleanliness) matchingAnswers++
        if (user1Answers.foodPreference == user2Answers.foodPreference) matchingAnswers++
        if (user1Answers.drinkingHabits == user2Answers.drinkingHabits) matchingAnswers++
        if (user1Answers.stayDuration == user2Answers.stayDuration) matchingAnswers++
        if (user1Answers.budget == user2Answers.budget) matchingAnswers++
        if (user1Answers.privacy == user2Answers.privacy) matchingAnswers++
        if (user1Answers.city == user2Answers.city) matchingAnswers++


        return (matchingAnswers / 10) * 100 // Assuming 10 questions
    }
}
