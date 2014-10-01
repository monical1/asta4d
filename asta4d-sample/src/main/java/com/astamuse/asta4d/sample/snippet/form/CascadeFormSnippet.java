/*
 * Copyright 2012 astamuse company,Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.astamuse.asta4d.sample.snippet.form;

import java.util.LinkedList;
import java.util.List;

import com.astamuse.asta4d.sample.handler.form.JobForm;
import com.astamuse.asta4d.sample.handler.form.PersonForm;
import com.astamuse.asta4d.sample.util.persondb.Person.BloodType;
import com.astamuse.asta4d.sample.util.persondb.Person.Language;
import com.astamuse.asta4d.sample.util.persondb.Person.SEX;
import com.astamuse.asta4d.web.form.field.FormFieldPrepareRenderer;
import com.astamuse.asta4d.web.form.field.impl.CheckboxPrepareRenderer;
import com.astamuse.asta4d.web.form.field.impl.RadioPrepareRenderer;
import com.astamuse.asta4d.web.form.field.impl.SelectPrepareRenderer;
import com.astamuse.asta4d.web.form.flow.classical.MultiStepFormFlowSnippet;

public class CascadeFormSnippet extends MultiStepFormFlowSnippet {
    @Override
    protected List<FormFieldPrepareRenderer> retrieveFieldPrepareRenderers(String renderTargetStep, Object form) {
        List<FormFieldPrepareRenderer> list = new LinkedList<>();
        if (form instanceof PersonForm) {
            list.add(new SelectPrepareRenderer(PersonForm.class, "bloodtype").setOptionData(BloodType.asOptionValueMap));
            list.add(new RadioPrepareRenderer(PersonForm.class, "sex").setOptionData(SEX.asOptionValueMap));
            list.add(new CheckboxPrepareRenderer(PersonForm.class, "language").setOptionData(Language.asOptionValueMap));
        } else if (form instanceof JobForm) {
            // ...
        }
        return list;
    }
}