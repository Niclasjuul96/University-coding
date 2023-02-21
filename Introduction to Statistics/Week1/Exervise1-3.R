before <- c(9.1, 8.0, 7.7, 10.0, 9.6, 7.9, 9.0, 7.1, 8.3, 9.6, 8.2, 9.2, 7.3, 8.5, 9.5)
after <- c(8.2, 6.4, 6.6, 8.5, 8.0, 5.8, 7.8, 7.2, 6.7, 9.8, 7.1, 7.7, 6.0, 6.6, 8.4)

#a)

sortedbefore <- sort(before)
sortedafter <- sort(after)

sortedafter
sortedbefore

#Median
sortedbefore[8]
sortedafter[8]


#Summery
summary(before)
summary(after)

quantile(before, type = 2)
quantile(after, type = 2)


#b)

mean(before)
mean(after)

sd(before)
sd(after)


#c)

## Calculate the sample covariance ’manually’ 
sum((before - mean(before)) * (after - mean(after))) / 14

sum((before - 8.6) * (after - 7.3867)) / 14

cov(before, after)

#d)

0.79643 / (0.90238 * 1.0901)

cov(before, after) / (sd(before) * sd(after))

cor(before, after)

#e)

diff <- after - before

summary(diff)

var(diff)

sd(diff)

boxplot(diff, col = 2)

## Analysis of 13 non-extreme differences
## Take out observation 8 and 10

diff13 <- diff[-c(8, 10)]

mean(diff13)

sd(diff13)


#f) 

## The grouped boxplot 
boxplot(list(before, after), col = 2:3)