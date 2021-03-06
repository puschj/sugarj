package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Assert$Stm_1_0 extends Strategy 
{ 
  public static $Assert$Stm_1_0 instance = new $Assert$Stm_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_20)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("AssertStm_1_0");
    Fail90:
    { 
      IStrategoTerm b_116 = null;
      IStrategoTerm a_116 = null;
      if(term.getTermType() != IStrategoTerm.APPL || renaming._consAssertStm_1 != ((IStrategoAppl)term).getConstructor())
        break Fail90;
      a_116 = term.getSubterm(0);
      IStrategoList annos73 = term.getAnnotations();
      b_116 = annos73;
      term = y_20.invoke(context, a_116);
      if(term == null)
        break Fail90;
      term = termFactory.annotateTerm(termFactory.makeAppl(renaming._consAssertStm_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, b_116));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}