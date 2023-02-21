x <- c(2474, 2547, 2830, 3219, 3429, 3448, 3677, 3872, 4001, 4116)
y <- c(2844, 2863, 2963, 3239, 3379, 3449, 3582, 3926, 4151, 4356)

#Female
mean(x)
var(x)
sd(x)

#Male
mean(y)
var(y)
sd(y)


boxplot(x, col = "red", main = "Female boxplot")
text(1.3, quantile(x), c("Minimum", "Q1", "Median", "Q3", "Maximum"), col = "blue") # nolint

boxplot(y, col = "red", main = "Male boxplot")
text(1.3, quantile(y), c("Minimum", "Q1", "Median", "Q3", "Maximum"), col = "blue") # nolint

#coefficient of variations
sd(x) / mean(x)
sd(y) / mean(y)
