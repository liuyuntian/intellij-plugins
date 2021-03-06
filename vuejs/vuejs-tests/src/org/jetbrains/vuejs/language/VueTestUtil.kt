package org.jetbrains.vuejs.language

import com.intellij.testFramework.fixtures.CodeInsightTestFixture

/**
 * @author Irina.Chernushina on 10/23/2017.
 */
fun directivesTestCase(myFixture: CodeInsightTestFixture) {
  myFixture.configureByText("CustomDirectives.js", """
Vue.directive('focus', {
    inserted: function (el) {
        el.focus()
    }
});
""")
  myFixture.configureByText("importedDirective.js", """
export default {
    inserted: {}
}
""")
  myFixture.configureByText("CustomDirectives.vue", """
<template>
    <label>
        <input v-focus v-local-directive v-some-other-directive/>
    </label>
    <client-comp v-imported-directive></client-comp>
    <div    style=""></div>
</template>

<script>
    import importedDirective from './importedDirective'
    let someOtherDirective = {

    };
    export default {
        name: "client-comp",
        directives: {
            localDirective: {
                // directive definition
                inserted: function (el) {
                    el.focus()
                }
            },
            someOtherDirective,
            importedDirective
        }
    }
</script>
""")
}