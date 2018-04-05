# Flight Search

## Problem

Your goal is to implement a simple flight search.

**Given**

* airport of origin
* airport of destination
* date of departure
* number of adult, child and infant passengers

**When** you perform the search

**Then** you get the list of:

* flight code matching the route
* total flight price (for all passengers)

## Implementation considerations

We ask you to solve it using the **Java** programming language. You are only allowed to use test libraries (JUnit, TestNG, Hamcrest,...) and nothing else.

You are free to implement any mechanism for feeding input into your solution (for example, using hard coded data within a unit test).

Remember that the **automated and self-checking tests** are mandatory. You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works correctly against the supplied test data.

We kindly ask you to put your code on a public project in `github.com` under your account. Use Maven or Gradle as automation tool and link it to a build service likeTravis CI.  

## What we value most?

The goal is to provide us with a full understanding of your coding style and skills. We’ll pay particular attention to:

* readable and well-structured code
* design and domain modelling
* quality of tests

## Business rules and constraints

* Search only for direct flights (no stopovers)
* Assume there is always seat availability
* All flights leave every day
* There is only one currency (€)

## Pricing rules

### Days to departure date
| days prior to the departure date | % of the base price |
|----------------------------------|---------------------|
| more than 30                     | 80%                 |
| 30 - 16                          | 100%                |
| 15 - 3                           | 120%                |
| less that 3                      | 150%                |

### Passenger type
| passenger type | price                                                                                          |
|----------------|------------------------------------------------------------------------------------------------|
| adult          | full price (i.e. price resulting from the *days to departure date* rule)                       |
| child          | 33% discount of the price calculated according to the *days to departure date* rule            |
| infant         | fixed price depending on the airline. Rule *days to departure date* is not applied for infants |

## Examples

* 1 adult, 30 days to the departure date, flying AMS -> FRA

  flights:

    * TK2372, 157.6 €
    * TK2659, 198.4 €
    * LH5909, 90.4 €

* 2 adults, 1 child, 1 infant, 15 days to the departure date, flying LHR -> IST

  flights:

    * TK8891, 806 € (2 * (120% of 250) + 67% of (120% of 250) + 5)
    * LH1085, 481.19 € (2 * (120% of 148) + 67% of (120% of 148) + 7)

* 1 adult, 2 children, 2 days to the departure date, flying BCN -> MAD

  flights:

    * IB2171, 909.09 € (150% of 259 + 2 * 67% of (150% of 259))
    * LH5496, 1028.43 € (150% of 293 + 2 * 67% of (150% of 293))

* CDG -> FRA

  no flights available

## Additional data

### Airports
| IATA code | city       |
|-----------|------------|
| MAD       | Madrid     |
| BCN       | Barcelona  |
| LHR       | London     |
| CDG       | Paris      |
| FRA       | Frakfurt   |
| IST       | Istanbul   |
| AMS       | Amsterdam  |
| FCO       | Rome       |
| CPH       | Copenhagen |

### Airlines with infant prices
| IATA code | name             | infant price |
|-----------|------------------|--------------|
| IB        | Iberia           | 10 €         |
| BA        | British Airways  | 15 €         |
| LH        | Lufthansa        | 7 €          |
| FR        | Ryanair          | 20 €         |
| VY        | Vueling          | 10 €         |
| TK        | Turkish Airlines | 5 €          |
| U2        | Easyjet          | 19.90 €      |

### Flights

In CSV format

```
origin,destination,airline,base price (€)
CPH,FRA,IB2818,186
CPH,LHR,U23631,152
CDG,MAD,IB8482,295
BCN,FRA,FR7521,150
CPH,FCO,TK4667,137
CPH,FCO,U24631,268
FCO,CDG,VY4335,158
LHR,IST,TK8891,250
FRA,AMS,U24107,237
CPH,BCN,U22593,218
BCN,IST,VY9890,178
AMS,CPH,TK4927,290
FCO,MAD,BA1164,118
CPH,LHR,BA7710,138
BCN,AMS,U24985,191
MAD,CDG,IB9961,128
LHR,FRA,LH2118,165
IST,FRA,IB8911,180
AMS,FRA,TK2372,197
FRA,IST,LH4145,169
MAD,CDG,IB6112,112
CPH,FRA,LH1678,298
LHR,CPH,LH6620,217
MAD,LHR,TK4199,186
MAD,CDG,IB7403,253
FRA,CPH,BA4369,109
BCN,MAD,IB2171,259
IST,LHR,LH6412,197
IST,MAD,LH1115,160
LHR,LHR,VY8162,285
FRA,LHR,BA8162,205
AMS,FCO,BA7610,168
LHR,IST,LH1085,148
FCO,FRA,U21423,274
CPH,MAD,U23282,113
CDG,CPH,LH5778,263
CPH,CDG,BA2777,284
BCN,LHR,TK4375,208
MAD,FCO,LH8408,149
AMS,IST,IB4563,109
LHR,FCO,LH5174,251
MAD,BCN,BA9569,232
AMS,FRA,TK2659,248
LHR,CDG,IB2771,289
IST,MAD,IB8688,150
CPH,AMS,TK8355,137
FCO,CDG,VY2974,111
AMS,FRA,LH5909,113
CPH,BCN,FR7949,176
BCN,CPH,U27858,237
FRA,AMS,LH2320,288
LHR,BCN,VY4633,149
AMS,IST,IB7289,163
FRA,LHR,IB9443,254
IST,FCO,LH4948,176
IST,BCN,TK5558,211
BCN,BCN,BA9409,215
IST,AMS,FR9261,267
CDG,IST,IB7181,227
LHR,BCN,TK1446,217
FCO,FRA,TK2793,175
AMS,CPH,FR1491,284
IST,BCN,IB9219,279
MAD,AMS,TK7871,159
FCO,AMS,VY4840,260
MAD,FRA,BA8982,171
IST,LHR,U23526,254
FRA,MAD,BA6773,157
CDG,CPH,IB5257,299
CPH,CDG,LH8545,230
LHR,AMS,IB4737,110
BCN,MAD,LH5496,293
CDG,LHR,U29718,103
LHR,AMS,BA9561,253
FRA,LHR,TK3167,118
IST,FRA,FR4727,108
CPH,IST,LH6320,115
LHR,AMS,BA6657,122
LHR,FRA,TK5342,295
IST,LHR,IB4938,226
CDG,BCN,VY9791,289
MAD,LHR,IB4124,272
FRA,MAD,BA7842,121
AMS,FCO,VY5092,178
CDG,LHR,BA9813,171
FRA,IST,BA2421,226
IST,CPH,U28059,262
MAD,AMS,LH7260,191
CDG,CPH,TK2044,186
```



