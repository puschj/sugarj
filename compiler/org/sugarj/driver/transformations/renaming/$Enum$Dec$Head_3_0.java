package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Enum$Dec$Head_3_0 extends Strategy 
{ 
  public static $Enum$Dec$Head_3_0 instance = new $Enum$Dec$Head_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_17, Strategy z_17, Strategy a_18)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("EnumDecHead_3_0");
    Fail53:
    { 
      IStrategoTerm b_108 = null;
      IStrategoTerm y_107 = null;
      IStrategoTerm z_107 = null;
      IStrategoTerm a_108 = null;
      IStrategoTerm c_108 = null;
      IStrategoTerm d_108 = null;
      if(term.getTermType() != IStrategoTerm.APPL || renaming._consEnumDecHead_3 != ((IStrategoAppl)term).getConstructor())
        break Fail53;
      y_107 = term.getSubterm(0);
      z_107 = term.getSubterm(1);
      a_108 = term.getSubterm(2);
      IStrategoList annos39 = term.getAnnotations();
      b_108 = annos39;
      term = y_17.invoke(context, y_107);
      if(term == null)
        break Fail53;
      c_108 = term;
      term = z_17.invoke(context, z_107);
      if(term == null)
        break Fail53;
      d_108 = term;
      term = a_18.invoke(context, a_108);
      if(term == null)
        break Fail53;
      term = termFactory.annotateTerm(termFactory.makeAppl(renaming._consEnumDecHead_3, new IStrategoTerm[]{c_108, d_108, term}), checkListAnnos(termFactory, b_108));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}