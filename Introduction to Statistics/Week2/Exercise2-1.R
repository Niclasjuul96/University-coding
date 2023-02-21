#A

dbinom(4, 10, 0.6)

#The distribution applied is the binomial distribution with n = 10 observations and p =0.6   # nolint
#the probability for success. The value, 0.1115 output by R is the value of the probability  # nolint
#density function (pdf) for x = 4, hence the probability of getting exactly 4 successes in   # nolint
#10 draws with replacement with a success probability of 60%.


#B
## P(X < 5) # nolint
pbinom(4, 10, 0.6)

## P(X <= 5) # nolint
pbinom(5, 10, 0.6)


## P(X > 4) # nolint
1 - pbinom(4, 10, 0.6)

## P(X = 5) # nolint
pbinom(5, 10, 0.6) - pbinom(4, 10, 0.6)

#C

dpois(4, 3)

# The Poisson distribution and the value is the probability of getting x = 4 events per interval when the average events per interval λ = 3 (i.e. the mean). # nolint

#D

##P(X<=5))
ppois(5, 3)
##P(X<5) #nolint
ppois(4, 3)
##P(X>4) #nolint

1 - ppois(4, 3)
##P(X=5) #nolint
ppois(5, 3) - ppois(4, 3)
