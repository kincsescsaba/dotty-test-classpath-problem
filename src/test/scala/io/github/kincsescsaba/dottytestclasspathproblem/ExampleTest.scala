package io.github.kincsescsaba.dottytestclasspathproblem

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

class ExampleTest extends AnyFeatureSpec, GivenWhenThen {
  Feature("Example feature") {
    Scenario("Classpath check") {
      val classPathEntries = System.getProperty("java.class.path").split(':').toList
      assert(classPathEntries.exists(_.contains("scala-library")))
      assert(classPathEntries.exists(_.contains("scala3-library")))
      assert(classPathEntries.exists(_.contains("scala3-compiler")))
    }
    Scenario("Scenario1") {
      assert(Repl("""println("Hello World!")""") == Passes)
    }
  }
}
