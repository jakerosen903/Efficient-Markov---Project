# Efficient-Markov---Project

An order-k Markov model uses strings of k-letters to predict text, these are called k-grams. It's also possible to use k-grams that are comprised of words rather than letters. An order-2 Markov model uses two-character strings or bigrams to calculate probabilities in generating random letters. A string called the training text is used to calculate the possibilities. 

I was responsible for implementing a more efficient version of the given class "BaseMarkov" to generate random text using the Markov model

To do this I had to create a new class "Efficient Markov" that extended BaseMarkov in order to create a Markov model with O(N) time complexity for a trainting text of size N. 

-- This project was done for CS201 at Duke University--
