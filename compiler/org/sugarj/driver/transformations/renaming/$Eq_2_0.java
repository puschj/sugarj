package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Eq_2_0 extends Strategy 
{ 
  public static $Eq_2_0 instance = new $Eq_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_23, Strategy g_23)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Eq_2_0");
    Fail124:
    { 
      IStrategoTerm l_122 = null;
      IStrategoTerm j_122 = null;
      IStrategoTerm k_122 = null;
      IStrategoTerm o_122 = null;
      if(term.getTermType() != IStrategoTerm.APPL || renaming._consEq_2 != ((IStrategoAppl)term).getConstructor())
        break Fail124;
      j_122 = term.getSubterm(0);
      k_122 = term.getSubterm(1);
      IStrategoList annos104 = term.getAnnotations();
      l_122 = annos104;
      term = f_23.invoke(context, j_122);
      if(term == null)
        break Fail124;
      o_122 = term;
      term = g_23.invoke(context, k_122);
      if(term == null)
        break Fail124;
      term = termFactory.annotateTerm(termFactory.makeAppl(renaming._consEq_2, new IStrategoTerm[]{o_122, term}), checkListAnnos(termFactory, l_122));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}