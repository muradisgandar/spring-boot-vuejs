<template>
  <div class="row">
    {{ productFeatures }}
  </div>
  <div class="row">
    info 2
  </div>
  <div class="row">
    info 3
  </div>
  <div class="row">
    info 4
  </div>
</template>

<script>
export default {
  name: "features",
  props: ['productFeatures']
}
</script>

<style scoped>

</style>