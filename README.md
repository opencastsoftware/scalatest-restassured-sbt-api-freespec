# scalatest-restassured-sbt-api with AnyFreeSpec

# Required software
- JAVA
- SBT

Link to documentation:
------------------------
https://www.scalatest.org/user_guide
https://www.scalatest.org/at_a_glance/FreeSpec
https://www.scalatest.org/scaladoc/3.2.5/org/scalatest/freespec/AnyFreeSpec.html

AnyFreeSpec extends AnyFreeSpecLike
Facilitates a “behavior-driven” style of development (BDD), 
in which tests are nested inside text clauses denoted with the dash operator (-).
AnyFreeSpec is so named because unlike classes such as AnyWordSpec, AnyFlatSpec, 
and AnyFunSpec, it is enforces no structure on the text. You are free to compose text however you like. 
(A AnyFreeSpec is like free-verse poetry as opposed to a sonnet or haiku, which defines a structure for the text of the poem.)


Recommended Usage: Because it gives absolute freedom (and no guidance) on how specification text should be written, 
AnyFreeSpec is a good choice for teams experienced with BDD and able to agree on how to structure the specification text.

## Running Tests

Tests are run via `sbt test` from the terminal.

## Running specific class/tests

sbt "test:testOnly *Requests"
