/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.standard.expression;



/**
 * <p>
 *   Context class that contains several conditions that might be of interest to the
 *   expression executor (like for instance, whether the expression comes from 
 *   preprocessing or not)
 * </p>
 * <p>
 *   Note a class with this name existed since 2.0.16, but it was completely reimplemented
 *   in Thymeleaf 3.0
 * </p>
 *
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 3.0.0
 *
 */
public final class StandardExpressionExecutionContext {

    public static final StandardExpressionExecutionContext RESTRICTED = new StandardExpressionExecutionContext(true, false);
    public static final StandardExpressionExecutionContext RESTRICTED_WITH_TYPE_CONVERSION = new StandardExpressionExecutionContext(true, true);
    public static final StandardExpressionExecutionContext NORMAL = new StandardExpressionExecutionContext(false, false);
    public static final StandardExpressionExecutionContext NORMAL_WITH_TYPE_CONVERSION = new StandardExpressionExecutionContext(false, true);

    private final boolean restrictVariableAccess;
    private final boolean performTypeConversion;
    
    
    private StandardExpressionExecutionContext(final boolean restrictVariableAccess, final boolean performTypeConversion) {
        super();
        this.restrictVariableAccess = restrictVariableAccess;
        this.performTypeConversion = performTypeConversion;
    }

    public boolean getRestrictVariableAccess() {
        return this.restrictVariableAccess;
    }

    public boolean getPerformTypeConversion() {
        return this.performTypeConversion;
    }

    public StandardExpressionExecutionContext withoutTypeConversion() {
        if (this == NORMAL_WITH_TYPE_CONVERSION) {
            return NORMAL;
        }
        if (this == RESTRICTED_WITH_TYPE_CONVERSION) {
            return RESTRICTED;
        }
        return this;
    }

    public StandardExpressionExecutionContext withTypeConversion() {
        if (this == NORMAL) {
            return NORMAL_WITH_TYPE_CONVERSION;
        }
        if (this == RESTRICTED) {
            return RESTRICTED_WITH_TYPE_CONVERSION;
        }
        return this;
    }


}
