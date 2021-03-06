package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Method$Name_1_0 extends Strategy 
{ 
  public static $Method$Name_1_0 instance = new $Method$Name_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_26)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("MethodName_1_0");
    Fail170:
    { 
      IStrategoTerm x_131 = null;
      IStrategoTerm w_131 = null;
      if(term.getTermType() != IStrategoTerm.APPL || renaming._consMethodName_1 != ((IStrategoAppl)term).getConstructor())
        break Fail170;
      w_131 = term.getSubterm(0);
      IStrategoList annos149 = term.getAnnotations();
      x_131 = annos149;
      term = f_26.invoke(context, w_131);
      if(term == null)
        break Fail170;
      term = termFactory.annotateTerm(termFactory.makeAppl(renaming._consMethodName_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, x_131));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}