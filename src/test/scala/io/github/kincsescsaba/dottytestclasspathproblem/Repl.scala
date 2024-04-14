package io.github.kincsescsaba.dottytestclasspathproblem

import dotty.tools.dotc.core.Comments.{ContextDoc, ContextDocstrings}
import dotty.tools.dotc.parsing.Parsers
import dotty.tools.dotc.util.SourceFile
import dotty.tools.dotc.core.Contexts
import dotty.tools.dotc.core.Contexts.{ContextBase, FreshContext}


sealed trait ReplState
case object Passes extends ReplState
case object Fails extends ReplState


class Repl(sourceCode: String):
  import Repl.*
  given ctx: Contexts.Context = context
  initializeCtx(context)
  private val tree = Parsers.parser(SourceFile.virtual("replvirtfile", sourceCode)).parse()
  println(tree)
  //TODO

object Repl:
  def apply(sourceCode: String): ReplState =
    //TODO
    new Repl(sourceCode)
    Passes
  private def context =
    val base = new ContextBase
    val context = base.initialCtx.fresh
    base.initialize()(using context)
    context
  private def initializeCtx(fc: FreshContext): Unit =
    fc.setSetting(fc.settings.encoding, "UTF8")
    fc.setSetting(fc.settings.classpath, System.getProperty("java.class.path"))
    fc.setSetting(fc.settings.language, List("experimental.erasedDefinitions"))
    fc.setProperty(ContextDoc, new ContextDocstrings)