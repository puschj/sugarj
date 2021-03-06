package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Lt$Eq_2_0 extends Strategy 
{ 
  public static $Lt$Eq_2_0 instance = new $Lt$Eq_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_23, Strategy k_23)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("LtEq_2_0");
    Fail126:
    { 
      IStrategoTerm x_122 = null;
      IStrategoTerm v_122 = null;
      IStrategoTerm w_122 = null;
      IStrategoTerm y_122 = null;
      if(term.getTermType() != IStrategoTerm.APPL || renaming._consLtEq_2 != ((IStrategoAppl)term).getConstructor())
        break Fail126;
      v_122 = term.getSubterm(0);
      w_122 = term.getSubterm(1);
      IStrategoList annos106 = term.getAnnotations();
      x_122 = annos106;
      term = j_23.invoke(context, v_122);
      if(term == null)
        break Fail126;
      y_122 = term;
      term = k_23.invoke(context, w_122);
      if(term == null)
        break Fail126;
      term = termFactory.annotateTerm(termFactory.makeAppl(renaming._consLtEq_2, new IStrategoTerm[]{y_122, term}), checkListAnnos(termFactory, x_122));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}