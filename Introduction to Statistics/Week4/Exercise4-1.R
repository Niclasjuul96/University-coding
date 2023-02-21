#A

x <- c(3003, 3005, 2997, 3006, 2999, 2998, 3007, 3005, 3001)
mean(x)


sd(x)


sd(x) / sqrt(9)


#B

5 * 3000


5 * 9


2 * (1 - pnorm(15010, mean = 15000, sd = sqrt(45)))


2 * pnorm(-1.4907)


#C

qt(0.975, 8)

t.test(x)

#D

qt(0.995, 8)

t.test(x, conf.level = 0.99)

#E

qchisq(c(0.975, 0.025), 8)

c(8 * 13.75 / qchisq(0.975, 8), 8 * 13.75 / qchisq(0.025, 8))

sqrt(c(8 * 13.75 / qchisq(0.975, 8), 8 * 13.75 / qchisq(0.025, 8)))


#F

qchisq(c(0.995, 0.005), 8)

c(8 * 13.75 / qchisq(0.995, 8), 8 * 13.75 / qchisq(0.005, 8))

sqrt(c(8 * 13.75 / qchisq(0.995, 8), 8 * 13.75 / qchisq(0.005, 8)))