package org.yray.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * （相当于ObjectStruture）
 */
public class CallAccount implements VisitedEle{
   private List<VisitedEle> eleList=new ArrayList<>();

   public void addEle(VisitedEle ele)
   {
       eleList.add(ele);
   }



    @Override
    public void accept(Visitor visitor) {
        eleList.stream().forEach(item->{
            item.accept(visitor);
        });
    }
}
