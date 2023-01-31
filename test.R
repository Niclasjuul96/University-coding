x <- seq(0, 10, 1)
boxplot(x, range = 0, col = "red", main="Basic box plot")
text(1.5, quantile(x), c("Minimum", "Q1", "Median", "Q3" , "Maximum"), col = "blue")
hist(x, col = "red", main="Basic hist" )
